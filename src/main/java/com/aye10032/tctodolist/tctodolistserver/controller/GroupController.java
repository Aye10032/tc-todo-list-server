package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.data.ResultCode;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: tc-todo-list-server
 * @className: GroupController
 * @Description: group controller层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/11 下午 4:51
 */
@Api(tags = "组管理")
@RestController
@RequestMapping("group")
@Slf4j
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private PlayerService playerService;

    @ApiOperation("添加组")
    @PostMapping("insertGroup")
    public void insertGroup(
            @ApiParam("玩家昵称") @RequestParam(value = "player_name") String player_name,
            @ApiParam("组名称") @RequestParam(value = "group_name") String group_name,
            @ApiParam("相关信息") @RequestParam(value = "information", required = false) String information
    ) {
        Player player = playerService.getPlayByName(player_name);
        if (StringUtils.isNotBlank(group_name)) {
            Integer group_id;
            if (player != null) {
                group_id = groupService.insertGroup(
                        player.getId(), group_name, StringUtils.isNotBlank(information) ? information : "");
            } else {
                group_id = groupService.insertGroup(
                        playerService.insertPlayer(player_name),
                        group_name, StringUtils.isNotBlank(information) ? information : "");
            }
            log.info("add group " + group_id + " " + group_name + " by " + player_name);
            playerService.addPlayerGroup(player_name, group_id);
        } else {
            throw new APIException(ResultCode.VALIDATE_FAILED.getCode(), ResultCode.VALIDATE_FAILED.getMsg());
        }
    }

}
