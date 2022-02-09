package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: tc-todo-list-server
 * @className: IUndertakeDao
 * @Description: undertake dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 11:09
 */
@Mapper
public interface IUndertakeDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"undertake_list\"")
    Integer UndertakeTableExist();

    @Update("create table undertake_list\n" +
            "(\n" +
            "\tid INTEGER not null\n" +
            "\t\tconstraint todo_list_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\tplayer_id INTEGER not null,\n" +
            "\tmsg TEXT,\n" +
            "\ttime BLOB not null,\n" +
            "\tlast_update_time BLOB,\n" +
            ");")
    void CreateUndertakeTable();

}
