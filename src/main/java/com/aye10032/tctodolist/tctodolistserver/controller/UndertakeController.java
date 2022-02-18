package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.Task;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.service.TaskService;
import com.aye10032.tctodolist.tctodolistserver.service.UndertakeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @program: tc-todo-list-server
 * @className: UndertakeController
 * @Description: undertake controller层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/16 上午 11:17
 */
@Api(tags = "承接任务")
@RestController
@RequestMapping("undertake")
@Slf4j
public class UndertakeController {

    @Autowired
    PlayerService playerService;
    @Autowired
    TaskService taskService;
    @Autowired
    UndertakeService undertakeService;


    @ApiOperation("承接任务")
    @PostMapping("undertakeTask")
    public void undertakeTask(
            @ApiParam("任务名称") @NotBlank(message = "任务名称不能为空") @RequestParam(value = "task_name") String task_name,
            @ApiParam("承接人ID") @NotBlank(message = "承接人不能为空") @RequestParam(value = "from_name") String player_name,
            @ApiParam("承接留言") @RequestParam(value = "msg") String msg
    ) {
        Player player = playerService.getPlayByName(player_name);
        Task task = taskService.getTaskByName(task_name);
        Integer undertake_id = undertakeService.insertUndertake(task.getId(), player.getId(), msg);
        taskService.addTaskUndertake(task_name, undertake_id);
        log.info("player " + player_name + " undertake task " + task_name);
    }

}
