package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.ResultVO;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @program: tc-todo-list-server
 * @className: PlayerController
 * @Description: player controller层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 下午 1:10
 */
@Api(tags = "玩家管理")
@RestController
@RequestMapping("player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @ApiOperation("添加玩家")
    @PostMapping("insertPlayer")
    public Integer insertPlayer(
            @ApiParam("玩家昵称") @RequestParam(value = "name") String name
    ) {
        return playerService.insertPlayer(name);
    }

    @ApiOperation("设置玩家管理员权限")
    @PostMapping("setPlayerAdmin")
    public void setPlayerAdmin(
            @ApiParam("更改权限对象") @RequestParam(value = "name") String name,
            @ApiParam("请求来源玩家") @RequestParam(value = "from_player") String from_player
    ) {
        if (playerService.isPlayerAdmin(from_player)) {
            playerService.setPlayerAdmin(name, from_player);
        }
    }

    @ApiOperation("更新玩家ID（改名时）")
    @PostMapping("updatePlayerName")
    public Integer updatePlayerName(
            @ApiParam("玩家现在的ID") @RequestParam(value = "name") String name
    ) {
        return playerService.updatePlayerName(name);
    }

    @GetMapping("getPlayer")
    public ResultVO<Player> getPlayer(
            @ApiParam("玩家昵称") @RequestParam(value = "name") String name
    ) {
        return new ResultVO<>(playerService.getPlayByName(name));
    }


}
