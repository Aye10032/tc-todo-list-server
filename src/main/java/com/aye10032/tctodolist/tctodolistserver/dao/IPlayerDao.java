package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: tc-todo-list-server
 * @className: IPlayerDao
 * @Description: player dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 10:49
 */
@Mapper
public interface IPlayerDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"player_list\"")
    Integer PlayerTableExist();

    @Update("create table player_list\n" +
            "(\n" +
            "\tid INTEGER not null\n" +
            "\t\tconstraint todo_list_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\tname TEXT not null,\n" +
            "\tuuid TEXT not null,\n" +
            "\top BLOB not null,\n" +
            "\tgroups BLOB,\n" +
            ");")
    void CreatePlayerTable();

}
