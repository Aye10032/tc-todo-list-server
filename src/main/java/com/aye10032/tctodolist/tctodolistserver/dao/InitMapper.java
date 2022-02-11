package com.aye10032.tctodolist.tctodolistserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: tc-todo-list-server
 * @className: InitMapper
 * @Description: 总表查询接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/11 下午 3:50
 */
@Mapper
public interface InitMapper {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"todo_group\"")
    Integer GroupTableExist();

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"todo_message\"")
    Integer MessageTableExist();

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"todo_player\"")
    Integer PlayerTableExist();

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"todo_task\"")
    Integer TaskTableExist();

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"todo_undertake\"")
    Integer UndertakeTableExist();

}
