package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

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
    @Autowired
    private GroupService groupService;

    @ApiOperation("添加玩家")
    @PostMapping("insertPlayer")
    public Integer insertPlayer(
            @ApiParam("玩家昵称") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "name") String name
    ) {
        return playerService.insertPlayer(name);
    }

    @ApiOperation("设置玩家管理员权限")
    @PostMapping("setPlayerAdmin")
    public void setPlayerAdmin(
            @ApiParam("更改权限对象") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "name") String name,
            @ApiParam("请求来源玩家") @RequestParam(value = "from_player") String from_player
    ) {
        if (playerService.isPlayerAdmin(from_player)) {
            playerService.setPlayerAdmin(name);
        }
    }

    @ApiOperation("更新玩家ID（改名时）")
    @PostMapping("updatePlayerName")
    public Integer updatePlayerName(
            @ApiParam("玩家现在的ID") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "name") String name
    ) {
        return playerService.updatePlayerName(name);
    }

    @ApiOperation("获取玩家信息")
    @GetMapping("getPlayer")
    public Player getPlayer(
            @ApiParam("玩家昵称") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "name") String name
    ) {
        return playerService.getPlayByName(name);
    }

    @ApiOperation("将玩家分配至组")
    @PostMapping("addPlayerToGroup")
    public void addPlayerToGroup(
            @ApiParam("组名称") @NotBlank(message = "组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("玩家昵称") @NotBlank(message = "玩家名称不能为空") @RequestParam(value = "player_name") String player_name) {
        Group group = groupService.getGroupByName(group_name);
        if (group == null) {
            throw new APIException("group doesn't exist");
        } else {
            playerService.addPlayerGroup(player_name, group.getId());
        }
    }


}
