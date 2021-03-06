package com.aye10032.tctodolist.tctodolistserver.service;

import com.aye10032.tctodolist.tctodolistserver.pojo.Player;

/**
 * @program: tc-todo-list-server
 * @className: PlayerService
 * @Description: player服务层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 上午 10:50
 */
public interface PlayerService {

    int insertPlayer(String name);

    void setPlayerAdmin(String name);

    boolean isPlayerAdmin(String name);

    Player getPlayByName(String name);

    Player getPlayerByUuid(String uuid);

    int updatePlayerName(String name);

    void addPlayerGroup(String name, Integer group_id);
}
