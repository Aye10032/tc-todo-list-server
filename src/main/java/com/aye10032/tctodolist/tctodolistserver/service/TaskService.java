package com.aye10032.tctodolist.tctodolistserver.service;

/**
 * @program: tc-todo-list-server
 * @className: TaskService
 * @Description: task service层
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/12 下午 12:58
 */
public interface TaskService {

    Integer insertTask(String task_name, String pos, Integer owner_id);

    Integer insertTask(String task_name, String pos, Integer owner_id, Integer group_id);

}
