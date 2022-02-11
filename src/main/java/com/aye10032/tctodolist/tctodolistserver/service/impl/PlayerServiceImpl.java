package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.IPlayerDao;
import com.aye10032.tctodolist.tctodolistserver.dao.PlayerListMapper;
import com.aye10032.tctodolist.tctodolistserver.dao.PlayerListMapper;
import com.aye10032.tctodolist.tctodolistserver.dao.PlayerMapper;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerList;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerListExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerList;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerListExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerPojo;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.util.MinecraftUtil;
import lombok.SneakyThrows;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.IOException;
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
@Validated
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerMapper playerMapper;


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

        return player.getId();
    }

    @Override
    public void setPlayerAdmin(String name) {
        Player player = getPlayByName(name);

        if (player != null) {
            player.setAdmin(true);
            PlayerExample example = new PlayerExample();
            example.createCriteria().andNameEqualTo(name);
            playerMapper.updateByExample(player, example);
        } else {
            throw new APIException("wrong ID");
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
        return playerLists.isEmpty() ? null : playerLists.get(0);
    }

    @Override
    public Player getPlayerByUuid(String uuid) {
        PlayerExample example = new PlayerExample();
        example.createCriteria().andUuidEqualTo(uuid);
        List<Player> playerList = playerMapper.selectByExample(example);
        return playerList.isEmpty() ? null : playerList.get(0);
    }


    @Override
    public int updatePlayerName(String name) {
        String uuid = MinecraftUtil.getUUID(name);
        Player player = getPlayerByUuid(uuid);
        if (player != null) {
            player.setName(name);
            PlayerExample example = new PlayerExample();
            example.createCriteria().andUuidEqualTo(uuid);
            playerMapper.updateByExample(player, example);
            return player.getId();
        } else {
            throw new APIException("player doesn't exist");
        }
    }


}
