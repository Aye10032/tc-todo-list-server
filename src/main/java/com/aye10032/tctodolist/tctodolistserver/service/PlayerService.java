package com.aye10032.tctodolist.tctodolistserver.service;

import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerPojo;
import org.springframework.validation.annotation.Validated;

/**
 * @program: tc-todo-list-server
 * @className: PlayerService
 * @Description: player服务层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/10 上午 10:50
 */
@Validated
public interface PlayerService {

    int insertPlayer(String name);

    void setPlayerAdmin(String name, String from_player);

    boolean isPlayerAdmin(String name);

}
