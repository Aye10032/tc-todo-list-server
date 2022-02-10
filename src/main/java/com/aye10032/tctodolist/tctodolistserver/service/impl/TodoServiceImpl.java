package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.ITodoDao;
import com.aye10032.tctodolist.tctodolistserver.dao.TodoListExample;
import com.aye10032.tctodolist.tctodolistserver.dao.TodoListMapper;
import com.aye10032.tctodolist.tctodolistserver.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 服务层 由服务层实现具体的业务逻辑
 * @author Dazo66
 */
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private ITodoDao todoDao;
    @Autowired
    private TodoListMapper todoListMapper;

    @Override
    public boolean doesTableExist() {
        return todoDao.TodoTableExist() == 1;
    }

    @Override
    public int getTodoListCount() {
        TodoListExample example = new TodoListExample();
        // 随便写的 举个例子 如何使用
        example.createCriteria().andStatusEqualTo("未完成");
        return (int) todoListMapper.countByExample(example);
    }

}
