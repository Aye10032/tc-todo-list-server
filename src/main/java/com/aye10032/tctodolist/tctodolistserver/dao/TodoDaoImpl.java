/*
package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

*/
/**
 * @program: tc-todo-list-server
 * @className: ITodoDaoImpl
 * @Description: todo接口实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 6:31
 *//*

public class TodoDaoImpl implements ITodoDao{

    private InputStream in;
    private SqlSession session;
    private ITodoDao dao;

    private void initSession() {
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            session = factory.openSession();
            dao = session.getMapper(ITodoDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeAll() {
        try {
            session.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer TodoTableExist() {
        Integer result = null;
        initSession();

        result = dao.TodoTableExist();

        closeAll();
        return result;
    }

    @Override
    public void CreateTodoTable() {
        initSession();

        dao.CreateTodoTable();

        session.commit();
        closeAll();
    }
}
*/
