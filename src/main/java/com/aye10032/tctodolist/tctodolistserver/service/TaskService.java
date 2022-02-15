package com.aye10032.tctodolist.tctodolistserver.service;

import com.aye10032.tctodolist.tctodolistserver.pojo.Task;

import java.util.List;

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

    Task getTaskByName(String task_name);

    List<Task> getTaskByGroup(List<Integer> groupList);

    List<Task> getUnfinishedTaskByGroup(List<Integer> groupList);

    void updateTaskStatus(String task_name, boolean status);

    void updateTaskInformation(String task_name, String new_task_name, String pos, Integer group_id);

    void deleteTask(String task_name);

}
