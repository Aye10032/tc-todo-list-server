package com.aye10032.tctodolist.tctodolistserver.service;

/**
 * @program: tc-todo-list-server
 * @className: UndertakeService
 * @Description: undertake service 层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/16 上午 11:06
 */
public interface UndertakeService {

    Integer insertUndertake(Integer task_id, Integer player_id, String msg);

}
