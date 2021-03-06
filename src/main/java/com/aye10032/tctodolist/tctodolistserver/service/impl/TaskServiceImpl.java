package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.PlayerMapper;
import com.aye10032.tctodolist.tctodolistserver.dao.TaskMapper;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.Task;
import com.aye10032.tctodolist.tctodolistserver.pojo.TaskExample;
import com.aye10032.tctodolist.tctodolistserver.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: TaskServiceImpl
 * @Description: tase service接口实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/12 下午 1:51
 */
@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskMapper taskMapper;

    @Override
    public Integer insertTask(String task_name, String pos, Integer owner_id) {
        return insertTask(task_name, pos, owner_id, 1);
    }

    @Override
    public Integer insertTask(String task_name, String pos, Integer owner_id, Integer group_id) {
        TaskExample example = new TaskExample();
        example.createCriteria().andNameEqualTo(task_name);
        if (taskMapper.countByExample(example) == 0) {
            Task task = new Task();
            task.setName(task_name);
            task.setPos(pos);
            task.setOwner(owner_id);
            task.setStatus(false);

            Date date = new Date();
            task.setTime(date.getTime());
            task.setLastUpdateTime(date.getTime());
            //加入默认组
            task.setGroups(group_id);

            List<Integer> undertakerList = new ArrayList<>();
            undertakerList.add(owner_id);
            task.setUndertakerList(undertakerList);

            taskMapper.insert(task);
            return task.getId();
        } else {
            throw new APIException("task name already exists!");
        }
    }

    @Override
    public Task getTaskByName(String task_name) {
        TaskExample example = new TaskExample();
        example.createCriteria().andNameEqualTo(task_name);
        List<Task> taskList = taskMapper.selectByExample(example);
        if (taskList.isEmpty()) {
            throw new APIException("task doesn't exist!");
        }
        return taskList.get(0);
    }

    @Override
    public List<Task> getTaskByGroup(List<Integer> groupList) {
        TaskExample example = new TaskExample();
        for (Integer group_id : groupList) {
            example.or(new TaskExample().createCriteria().andGroupsEqualTo(group_id));
        }
        return taskMapper.selectByExample(example);
    }

    @Override
    public List<Task> getUnfinishedTaskByGroup(List<Integer> groupList) {
        TaskExample example = new TaskExample();
        for (Integer group_id : groupList) {
            example.or(new TaskExample().createCriteria().andGroupsEqualTo(group_id).andStatusEqualTo(false));
        }
        return taskMapper.selectByExample(example);
    }

    @Override
    public void updateTaskStatus(String task_name, boolean status) {
        Task task = getTaskByName(task_name);
        task.setStatus(status);
        task.setLastUpdateTime(new Date().getTime());

        TaskExample example = new TaskExample();
        example.createCriteria().andNameEqualTo(task_name);
        taskMapper.updateByExample(task, example);
    }

    @Override
    public void updateTaskInformation(String task_name, String new_task_name, String pos, Integer group_id) {
        Task task = getTaskByName(task_name);
        if (StringUtils.isNotBlank(new_task_name)) {
            TaskExample example = new TaskExample();
            example.createCriteria().andNameEqualTo(new_task_name);
            if (taskMapper.countByExample(example) == 0) {
                task.setName(new_task_name);
            }
        }
        if (StringUtils.isNotBlank(pos)) {
            task.setPos(pos);
        }
        if (group_id != null) {
            task.setGroups(group_id);
        }
        task.setLastUpdateTime(new Date().getTime());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void addTaskUndertake(String task_name, Integer undertake_id) {
        Task task = getTaskByName(task_name);
        List<Integer> undertake_list = task.getUndertakerList();
        if (!undertake_list.contains(undertake_id)){
            undertake_list.add(undertake_id);
        }
        task.setUndertakerList(undertake_list);
        task.setLastUpdateTime(new Date().getTime());
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public void deleteTask(String task_name) {
        TaskExample example = new TaskExample();
        example.createCriteria().andNameEqualTo(task_name);
        taskMapper.deleteByExample(example);
    }
}
