package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.GroupMapper;
import com.aye10032.tctodolist.tctodolistserver.dao.PlayerMapper;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerExample;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.util.MinecraftUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: PlayerServiceImpl
 * @Description: player服务层实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 上午 10:52
 */
@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private GroupMapper groupMapper;


    @Override
    public int insertPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        player.setUuid(MinecraftUtil.getUUID(name));
        player.setAdmin(false);

        //默认加入服务器组
        List<Integer> group = new ArrayList<>();
        group.add(1);
        player.setGroups(group);
        playerMapper.insert(player);

        return player.getId();
    }

    @Override
    public void setPlayerAdmin(String name) {
        Player player = getPlayByName(name);
        player.setAdmin(true);
        PlayerExample example = new PlayerExample();
        example.createCriteria().andNameEqualTo(name);
        playerMapper.updateByExample(player, example);

        GroupExample groupExample = new GroupExample();
        groupExample.createCriteria().andIdEqualTo(1);
        Group group = groupMapper.selectByPrimaryKey(1);
        List<Integer> admins = group.getAdmins();
        if (!admins.contains(player.getId())) {
            admins.add(player.getId());
            group.setAdmins(admins);
            groupMapper.updateByExample(group, groupExample);
        }
    }

    @Override
    public boolean isPlayerAdmin(String name) {
        String uuid = MinecraftUtil.getUUID(name);
        PlayerExample example = new PlayerExample();
        example.createCriteria().andUuidEqualTo(uuid);
        List<Player> playerList = playerMapper.selectByExample(example);
        return !playerList.isEmpty() && playerList.get(0).getAdmin();
    }

    @Override
    public Player getPlayByName(String name) {
        PlayerExample example = new PlayerExample();
        example.createCriteria().andNameEqualTo(name);
        List<Player> playerLists = playerMapper.selectByExample(example);
        if (playerLists.isEmpty()) {
            throw new APIException("player doesn't exist");
        }
        return playerLists.get(0);
    }

    @Override
    public Player getPlayerByUuid(String uuid) {
        PlayerExample example = new PlayerExample();
        example.createCriteria().andUuidEqualTo(uuid);
        List<Player> playerList = playerMapper.selectByExample(example);
        if (playerList.isEmpty()) {
            throw new APIException("player doesn't exist");
        }
        return playerList.get(0);
    }


    @Override
    public int updatePlayerName(String name) {
        String uuid = MinecraftUtil.getUUID(name);
        Player player = getPlayerByUuid(uuid);
        player.setName(name);
        PlayerExample example = new PlayerExample();
        example.createCriteria().andUuidEqualTo(uuid);
        playerMapper.updateByExample(player, example);
        return player.getId();
    }

    @Override
    public void addPlayerGroup(String name, Integer group_id) {
        PlayerExample example = new PlayerExample();
        example.createCriteria().andNameEqualTo(name);
        List<Player> playerList = playerMapper.selectByExample(example);
        Player player = playerList.get(0);
        List<Integer> groups = player.getGroups();
        if (!groups.contains(group_id)) {
            groups.add(group_id);
            player.setGroups(groups);
            playerMapper.updateByExample(player, example);
        }
    }


}
