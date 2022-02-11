package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.Message;
import com.aye10032.tctodolist.tctodolistserver.pojo.MessageExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface MessageMapper {
    @SelectProvider(type=MessageSqlProvider.class, method="countByExample")
    long countByExample(MessageExample example);

    @DeleteProvider(type=MessageSqlProvider.class, method="deleteByExample")
    int deleteByExample(MessageExample example);

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
        "#{msg,jdbcType=VARCHAR}, #{hasRead,jdbcType=BOOLEAN}, #{fromTodo,jdbcType=INTEGER})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Message record);

    @InsertProvider(type=MessageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Message record);

    @SelectProvider(type=MessageSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="from_player", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="target_player", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="send_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="last_update_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="msg", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="has_read", javaType=Boolean.class, jdbcType=JdbcType.BOOLEAN),
        @Arg(column="from_todo", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<Message> selectByExample(MessageExample example);

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
        @Arg(column="has_read", javaType=Boolean.class, jdbcType=JdbcType.BOOLEAN),
        @Arg(column="from_todo", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    Message selectByPrimaryKey(Integer id);

    @UpdateProvider(type=MessageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    @UpdateProvider(type=MessageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    @UpdateProvider(type=MessageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Message record);

    @Update({
        "update todo_message",
        "set from_player = #{fromPlayer,jdbcType=INTEGER},",
          "target_player = #{targetPlayer,jdbcType=INTEGER},",
          "send_time = #{sendTime,jdbcType=NUMERIC},",
          "last_update_time = #{lastUpdateTime,jdbcType=NUMERIC},",
          "msg = #{msg,jdbcType=VARCHAR},",
          "has_read = #{hasRead,jdbcType=BOOLEAN},",
          "from_todo = #{fromTodo,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Message record);
}