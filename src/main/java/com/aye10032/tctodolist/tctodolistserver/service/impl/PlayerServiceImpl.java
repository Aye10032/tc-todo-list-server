package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.IPlayerDao;
import com.aye10032.tctodolist.tctodolistserver.dao.PlayerListMapper;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerList;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerListExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerPojo;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
import com.aye10032.tctodolist.tctodolistserver.util.MinecraftUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private IPlayerDao playerDao;
    @Autowired
    private PlayerListMapper playerListMapper;

    @Override
    public boolean doesTableExist() {
        return playerDao.PlayerTableExist() == 1;
    }

/*    @SneakyThrows
    @Override
    public int insertPlayer(String name, boolean op) {
        PlayerPojo player = new PlayerPojo();
        player.setName(name);
        player.setUuid(MinecraftUtil.getUUID(name));
        player.setOp(op);

        //默认加入服务器组
        List<Integer> group = new ArrayList<>();
        group.add(0);
        player.setGroups(group);

        return playerDao.insertPlayer(player);
    }*/

    @Override
    @SneakyThrows
    public int insertPlayer(String name, boolean op) {
        PlayerList player = new PlayerList();
        player.setName(name);
        player.setUuid(MinecraftUtil.getUUID(name));
        player.setOp(String.valueOf(op));

        //默认加入服务器组
        List<Integer> group = new ArrayList<>();
        group.add(0);
        player.setGroups(group);
        return playerListMapper.insert(player);

    }

    @Override
    public PlayerList getPlayByName(String name) {
        PlayerListExample example = new PlayerListExample();
        example.createCriteria().andNameEqualTo(name);
        List<PlayerList> playerLists = playerListMapper.selectByExample(example);
        return playerLists.isEmpty() ? null : playerLists.get(0);
    }

}
