package com.aye10032.tctodolist.tctodolistserver.util;

import com.aye10032.tctodolist.tctodolistserver.TcTodoListServerApplication;
import com.aye10032.tctodolist.tctodolistserver.dao.ITodoDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @program: tc-todo-list-server
 * @className: ServerInit
 * @Description: 初始化工具类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 6:11
 */
public class ServerInit {

    public static void init(){
        Logger logger = LoggerFactory.getLogger("tc-todo-list-server");
        File database = new File("todo.db");
        ITodoDaoImpl todoDao = new ITodoDaoImpl();

        if (!database.exists()){
            logger.info("database created");
            todoDao.CreateTodoTable();
        }
    }

}
