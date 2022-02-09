package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.ITodoDao;
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

    @Override
    public boolean doesTableExist() {
        return todoDao.TodoTableExist() == 1;
    }
}
