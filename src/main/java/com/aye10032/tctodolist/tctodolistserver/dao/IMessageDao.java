package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: tc-todo-list-server
 * @className: IMessageDao
 * @Description: message dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 11:00
 */
@Mapper
public interface IMessageDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"message_list\"")
    Integer MessageTableExist();

    @Update("create table message_list\n" +
            "(\n" +
            "\tid INTEGER not null\n" +
            "\t\tconstraint todo_list_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\tfrom_player INTEGER not null,\n" +
            "\ttarget_player INTEGER not null,\n" +
            "\tsend_time BLOB not null,\n" +
            "\tlast_update_time BLOB not null,\n" +
            "\tmsg TEXT not null,\n" +
            "\thas_read BLOB not null,\n" +
            "\tfrom_todo INTEGER\n" +
            ");")
    void CreateMessageTable();

}
