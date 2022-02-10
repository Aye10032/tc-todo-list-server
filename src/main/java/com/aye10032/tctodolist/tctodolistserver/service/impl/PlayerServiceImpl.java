package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.IPlayerDao;
import com.aye10032.tctodolist.tctodolistserver.dao.PlayerListMapper;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerList;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerListExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerPojo;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.util.MinecraftUtil;
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
    private IPlayerDao playerDao;
    @Autowired
    private PlayerListMapper playerListMapper;


    @SneakyThrows
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

        return playerListMapper.insert(player);
    }

    @Override
    public void setPlayerAdmin(String name, String from_player) {

    }

    @Override
    public boolean isPlayerAdmin(String name) {
        return false;
    }

    @Override
    public PlayerList getPlayByName(String name) {
        PlayerListExample example = new PlayerListExample();
        example.createCriteria().andNameEqualTo(name);
        List<PlayerList> playerLists = playerListMapper.selectByExample(example);
        return playerLists.isEmpty() ? null : playerLists.get(0);
    }


}
