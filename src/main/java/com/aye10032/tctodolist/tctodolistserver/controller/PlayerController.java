package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.dao.IPlayerDao;
import com.aye10032.tctodolist.tctodolistserver.data.ResultVO;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
