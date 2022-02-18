package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.Task;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.service.TaskService;
import com.aye10032.tctodolist.tctodolistserver.service.UndertakeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: TaskController
 * @Description: task controller 层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/12 下午 2:16
 */
@Api(tags = "任务管理")
@RestController
@RequestMapping("task")
@Slf4j
public class TaskController {

    @Autowired
    TaskService taskService;
    @Autowired
    PlayerService playerService;
    @Autowired
    GroupService groupService;
    @Autowired
    UndertakeService undertakeService;

    @ApiOperation("添加任务")
    @PostMapping("insertTask")
    public Integer insertTask(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name,
            @ApiParam("任务关键点坐标") @Pattern(regexp = "^-?[0-9]+ +-?[0-9]+$", message = "格式必须为\"x z\"") @RequestParam(value = "pos") String pos,
            @ApiParam("任务创建人") @NotBlank(message = "创建人不能为空") @RequestParam(value = "owner_name") String owner_name,
            @ApiParam("任务所属组(留空则默认为服务器组)") @RequestParam(value = "group_name", required = false) String group_name,
            @ApiParam("承接留言") @RequestParam(value = "msg", required = false) String msg) {
        Player player = playerService.getPlayByName(owner_name);
        if (player == null) {
            throw new APIException("player doesn't exists!");
        }
        int result = -1;
        if (StringUtils.isNotBlank(group_name)) {
            Group group = groupService.getGroupByName(group_name);
            if (group == null) {
                throw new APIException("group doesn't exists!");
            }
            result = taskService.insertTask(task_name, pos, player.getId(), group.getId());
            log.info("add task " + task_name + " to group " + group_name);
        } else {
            result = taskService.insertTask(task_name, pos, player.getId());
            log.info("add task " + task_name);
        }
        Integer undertake_id = undertakeService.insertUndertake(result, player.getId(), msg);
        taskService.addTaskUndertake(task_name, undertake_id);
        return result;
    }

    @ApiOperation("获取任务对象")
    @GetMapping("getTask")
    public Task getTask(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name
    ) {
        return taskService.getTaskByName(task_name);
    }

    @ApiOperation("获取可访问任务列表")
    @GetMapping("getAvailableTasks")
    public List<Task> getAvailableTasks(
            @ApiParam("玩家昵称") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "player_name") String player_name
    ) {
        Player player = playerService.getPlayByName(player_name);
        List<Integer> player_group = player.getGroups();
        return taskService.getTaskByGroup(player_group);
    }

    @ApiOperation("获取未完成的可访问任务列表")
    @GetMapping("getUnfinishedTask")
    public List<Task> getUnfinishedTask(
            @ApiParam("玩家昵称") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "player_name") String player_name
    ) {
        Player player = playerService.getPlayByName(player_name);
        List<Integer> player_group = player.getGroups();
        return taskService.getUnfinishedTaskByGroup(player_group);
    }

    @ApiOperation("更新任务状态")
    @PostMapping("updateTaskStatus")
    public void updateTaskStatus(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name,
            @ApiParam("任务状态") @NotNull(message = "任务状态不能为空") @RequestParam(value = "status") Boolean status,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_name") String from_name
    ) {
        if (hasTaskAccess(task_name, from_name)) {
            taskService.updateTaskStatus(task_name, status);
            log.info("update task " + task_name + " status to " + status);
        }
    }

    @ApiOperation("更新任务信息")
    @PostMapping("updateTaskInformation")
    public void updateTaskInformation(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name,
            @ApiParam("新任务名称") @RequestParam(value = "new_task_name", required = false) String new_task_name,
            @ApiParam("新任务关键点坐标") @Pattern(regexp = "^-?[0-9]+ +-?[0-9]+$", message = "格式必须为\"x z\"") @RequestParam(value = "pos", required = false) String pos,
            @ApiParam("新任务所属组") @RequestParam(value = "group_name", required = false) String group_name,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_name") String from_name
    ) {
        if (hasTaskAccess(task_name, from_name)) {
            Integer group_id = -1;
            if (StringUtils.isNotBlank(group_name)) {
                Group group = groupService.getGroupByName(group_name);
                group_id = group.getId();
            }
            taskService.updateTaskInformation(task_name, new_task_name, pos, group_id);
            log.info("update task " + task_name + " information");
        }
    }

    @ApiOperation("删除任务")
    @PostMapping("deleteTask")
    public void deleteTask(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_name") String from_name
    ) {
        if (hasTaskFinalAccess(task_name, from_name)) {
            taskService.deleteTask(task_name);
            log.info("delete task " + task_name + " by player " + from_name);
        }
    }

    private boolean hasTaskFinalAccess(String task_name, String player_name) {
        Task task = taskService.getTaskByName(task_name);
        Player player = playerService.getPlayByName(player_name);

        if (player.getAdmin()) {
            return true;
        }
        Group group = groupService.getGroupById(task.getGroups());
        return group.getOwner().equals(player.getId());
    }

    private boolean hasTaskAccess(String task_name, String player_name) {
        Task task = taskService.getTaskByName(task_name);
        Player player = playerService.getPlayByName(player_name);

        if (player.getAdmin()) {
            return true;
        }
        Group group = groupService.getGroupById(task.getGroups());
        return group.getAdmins().contains(player.getId());
    }
}
