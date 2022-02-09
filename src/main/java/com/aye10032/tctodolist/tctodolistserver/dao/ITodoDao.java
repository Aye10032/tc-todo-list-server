package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: tc-todo-list-server
 * @className: ITodoDao
 * @Description: 任务数据表dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 6:23
 */
public interface ITodoDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"todo_list\"")
    Integer TableExist();

    @Update("create table todo_list\n" +
            "(\n" +
            "\tid INTEGER not null\n" +
            "\t\tconstraint todo_list_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\tname TEXT not null,\n" +
            "\tpos TEXT,\n" +
            "\towner INTEGER not null,\n" +
            "\ttime BLOB not null,\n" +
            "\tlast_update_time BLOB not null,\n" +
            "\t\"group\" INTEGER not null,\n" +
            "\tstatus BLOB not null,\n" +
            "\tundertaker_list BLOB not null\n" +
            ");")
    void CreateTodoTable();

}
