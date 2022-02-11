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
        PlayerList player = new PlayerList();
        player.setName(name);
        player.setUuid(MinecraftUtil.getUUID(name));
        player.setOp(String.valueOf(false));
        //默认加入服务器组
        List<Integer> group = new ArrayList<>();
        group.add(0);
        player.setGroups(group);

        return player.getId();
    }

    @Override
    public void setPlayerAdmin(String name, String from_player) {
        String uuid = MinecraftUtil.getUUID(name);
        List<PlayerPojo> players = playerDao.selectPlayerByUUID(uuid);

        if (!players.isEmpty()) {
            PlayerPojo player = players.get(0);
            player.setName(name);
            player.setOp(true);
            playerDao.updatePlayerByUUID(player);
        } else {
            PlayerPojo player = new PlayerPojo(name, uuid, true);

            playerDao.insertPlayer(player);
        }
    }

    @Override
    public boolean isPlayerAdmin(String name) {
        List<PlayerPojo> players = playerDao.selectPlayerByName(name);
        PlayerPojo player;
        if (players.isEmpty()) {
            String uuid = MinecraftUtil.getUUID(name);
            players = playerDao.selectPlayerByUUID(uuid);

            if (players.isEmpty()) {
                log.error("wrong player ID");
                return false;
            } else {
                player = players.get(0);
                player.setName(name);
                playerDao.insertPlayer(player);

                return player.getOp();
            }
        } else {
            player = players.get(0);
            return player.getOp();
        }
    }

    @Override
    public Player getPlayByName(String name) {
        PlayerExample example = new PlayerExample();
        example.createCriteria().andNameEqualTo(name);
        List<Player> playerLists = playerMapper.selectByExample(example);
        return playerLists.isEmpty() ? null : playerLists.get(0);
    }

    @Override
    public int updatePlayerName(String name) {
        String uuid = MinecraftUtil.getUUID(name);
        PlayerPojo player = playerDao.selectPlayerByUUID(uuid).get(0);
        player.setName(name);
        playerDao.updatePlayerByUUID(player);
        return player.getId();
    }


}
