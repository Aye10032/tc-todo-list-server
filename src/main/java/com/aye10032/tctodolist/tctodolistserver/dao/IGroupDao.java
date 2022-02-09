package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @program: tc-todo-list-server
 * @className: IGroupDao
 * @Description: group dao 接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 10:54
 */
public interface IGroupDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"group_list\"")
    Integer GroupTableExist();

    @Update("create table group_list\n" +
            "(\n" +
            "\tid INTEGER not null\n" +
            "\t\tconstraint todo_list_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\towner INTEGER not null,\n" +
            "\tadmins BLOB,\n" +
            ");")
    void CreateGroupTable();

}
