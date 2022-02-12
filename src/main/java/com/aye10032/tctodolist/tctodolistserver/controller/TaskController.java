package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.Task;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

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

    @ApiOperation("添加任务")
    @PostMapping("insertTask")
    public Integer insertTask(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name,
            @ApiParam("任务关键点坐标") @Pattern(regexp = "^-?[0-9]+ +-?[0-9]+$", message = "格式必须为\"x z\"") @RequestParam(value = "pos") String pos,
            @ApiParam("任务创建人") @NotBlank(message = "创建人不能为空") @RequestParam(value = "owner_name") String owner_name,
            @ApiParam("任务所属组(留空则默认为服务器组)") @RequestParam(value = "group_name", required = false) String group_name){
        Player player = playerService.getPlayByName(owner_name);
        if (player == null){
            throw new APIException("player doesn't exists!");
        }
        int result = -1;
        if (StringUtils.isNotBlank(group_name)){
            Group group = groupService.getGroupByName(group_name);
            if (group == null){
                throw new APIException("group doesn't exists!");
            }
            result = taskService.insertTask(task_name, pos, player.getId(), group.getId());
            log.info("add task " + task_name + " to group " + group_name);
        }else {
            result = taskService.insertTask(task_name, pos, player.getId());
            log.info("add task " + task_name);
        }
        return result;
    }

    @ApiOperation("获取任务对象")
    @GetMapping("getTask")
    public Task getTask(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name
    ){
        return taskService.getTaskByName(task_name);
    }

}
