package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.TodoList;
import com.aye10032.tctodolist.tctodolistserver.pojo.TodoListExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TodoListMapper {
    @SelectProvider(type=TodoListSqlProvider.class, method="countByExample")
    long countByExample(TodoListExample example);

    @DeleteProvider(type=TodoListSqlProvider.class, method="deleteByExample")
    int deleteByExample(TodoListExample example);

    @Delete({
        "delete from todo_message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into todo_message (from_player, target_player, ",
        "send_time, last_update_time, ",
        "msg, has_read, from_todo)",
        "values (#{fromPlayer,jdbcType=INTEGER}, #{targetPlayer,jdbcType=INTEGER}, ",
        "#{sendTime,jdbcType=NUMERIC}, #{lastUpdateTime,jdbcType=NUMERIC}, ",
        "#{msg,jdbcType=VARCHAR}, #{hasRead,jdbcType=INTEGER}, #{fromTodo,jdbcType=INTEGER})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TodoList record);

    @InsertProvider(type=TodoListSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TodoList record);

    @SelectProvider(type=TodoListSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="from_player", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="target_player", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="send_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="last_update_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="msg", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="has_read", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="from_todo", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<TodoList> selectByExample(TodoListExample example);

    @Select({
        "select",
        "id, from_player, target_player, send_time, last_update_time, msg, has_read, ",
        "from_todo",
        "from todo_message",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="from_player", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="target_player", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="send_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="last_update_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="msg", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="has_read", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="from_todo", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    TodoList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TodoListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TodoList record, @Param("example") TodoListExample example);

    @UpdateProvider(type=TodoListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TodoList record, @Param("example") TodoListExample example);

    @UpdateProvider(type=TodoListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TodoList record);

    @Update({
        "update todo_message",
        "set from_player = #{fromPlayer,jdbcType=INTEGER},",
          "target_player = #{targetPlayer,jdbcType=INTEGER},",
          "send_time = #{sendTime,jdbcType=NUMERIC},",
          "last_update_time = #{lastUpdateTime,jdbcType=NUMERIC},",
          "msg = #{msg,jdbcType=VARCHAR},",
          "has_read = #{hasRead,jdbcType=INTEGER},",
          "from_todo = #{fromTodo,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TodoList record);
}