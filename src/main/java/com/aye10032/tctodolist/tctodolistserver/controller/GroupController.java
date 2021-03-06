package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

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
            @ApiParam("玩家ID") @NotBlank(message = "玩家ID不能为空") @RequestParam(value = "player_name") String player_name,
            @ApiParam("组名称(唯一)") @NotBlank(message = "组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("相关信息") @RequestParam(value = "information", required = false) String information
    ) {
        Player player = playerService.getPlayByName(player_name);
        Integer group_id = groupService.insertGroup(
                player.getId(), group_name, StringUtils.isNotBlank(information) ? information : "");

        log.info("insert group " + group_id + " " + group_name + " by " + player_name);
        playerService.addPlayerGroup(player_name, group_id);
    }

    @ApiOperation("获取组对象")
    @GetMapping("getGroup")
    public Group getGroup(
            @ApiParam("组名称") @RequestParam(value = "group_name") String group_name) {
        return groupService.getGroupByName(group_name);
    }

    @ApiOperation("添加组管理员")
    @PostMapping("insertGroupAdmin")
    public void insertGroupAdmin(
            @ApiParam("组名称") @NotBlank(message = "组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("玩家ID") @NotBlank(message = "玩家ID不能为空") @RequestParam(value = "player_name") String player_name,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_player") String from_player
    ) {
        if (hasGroupAccess(group_name, from_player)) {
            Group group = groupService.getGroupByName(group_name);
            Player target = playerService.getPlayByName(player_name);
            groupService.insertAdminById(group.getId(), target.getId());
            playerService.addPlayerGroup(player_name, group.getId());

            log.info("add group \"" + group_name + "\" admin " + player_name);
        } else {
            throw new APIException("no access");
        }
    }

    @ApiOperation("删除组管理员")
    @PostMapping("deleteGroupAdmin")
    public void deleteGroupAdmin(
            @ApiParam("组名称") @NotBlank(message = "组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("玩家ID") @NotBlank(message = "玩家ID不能为空") @RequestParam(value = "player_name") String player_name,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_player") String from_player
    ) {
        if (hasGroupAccess(group_name, from_player)) {
            Group group = groupService.getGroupByName(group_name);
            Player target = playerService.getPlayByName(player_name);
            groupService.deleteAdminById(group.getId(), target.getId());

            log.info("delete group \"" + group_name + "\" admin " + player_name);
        } else {
            throw new APIException("no access");
        }
    }

    @ApiOperation("修改组名称")
    @PostMapping("updateGroupName")
    public void updateGroupName(
            @ApiParam("原组名称") @NotBlank(message = "原组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("新组名称(唯一)") @NotBlank(message = "新组名称不能为空") @RequestParam(value = "new_group_name") String new_group_name,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_player") String from_player
    ) {
        if (hasGroupAccess(group_name, from_player)) {
            groupService.updateGroupName(group_name, new_group_name);

            log.info("update group \"" + group_name + "\" name to \"" + new_group_name +"\"");
        } else {
            throw new APIException("no access");
        }
    }

    @ApiOperation("修改组简介")
    @PostMapping("updateGroupInformation")
    public void updateGroupInformation(
            @ApiParam("组名称") @NotBlank(message = "组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("组简介") @RequestParam(value = "group_information") String group_information,
            @ApiParam("请求来源玩家ID") @NotBlank(message = "请求人不能为空") @RequestParam(value = "from_player") String from_player
    ) {
        if (hasGroupAccess(group_name, from_player)) {
            groupService.updateGroupInformation(group_name, group_information);

            log.info("update group \"" + group_name + "\" information to \"" + group_information +"\"");
        } else {
            throw new APIException("no access");
        }
    }

    @ApiOperation("删除组")
    @PostMapping("deleteGroup")
    public void deleteGroup(
            @ApiParam("组名称") @NotBlank(message = "组名称不能为空") @RequestParam(value = "group_name") String group_name,
            @ApiParam("请求来源玩家ID") @RequestParam(value = "from_player") String from_player
    ) {
        if (hasGroupFinalAccess(group_name, from_player)) {
            groupService.deleteGroupByName(group_name);

            log.info("delete group "  + group_name);
        } else {
            throw new APIException("no access");
        }
    }

    private Boolean hasGroupFinalAccess(String group_name, String player_name) {
        Group group = groupService.getGroupByName(group_name);
        Player requester = playerService.getPlayByName(player_name);

        if (group.getOwner().equals(requester.getId())) {
            return true;
        } else return playerService.isPlayerAdmin(player_name);
    }

    private Boolean hasGroupAccess(String group_name, String player_name) {
        Group group = groupService.getGroupByName(group_name);
        Player requester = playerService.getPlayByName(player_name);

        if (group.getAdmins().contains(requester.getId())) {
            return true;
        } else if (group.getOwner().equals(requester.getId())) {
            return true;
        } else return playerService.isPlayerAdmin(player_name);
    }

}
