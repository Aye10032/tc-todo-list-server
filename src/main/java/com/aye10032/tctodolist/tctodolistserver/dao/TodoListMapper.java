package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.TodoList;
import com.aye10032.tctodolist.tctodolistserver.pojo.TodoListExample;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface TodoListMapper {
    @SelectProvider(type=TodoListSqlProvider.class, method="countByExample")
    long countByExample(TodoListExample example);

    @DeleteProvider(type=TodoListSqlProvider.class, method="deleteByExample")
    int deleteByExample(TodoListExample example);

    @Delete({
        "delete from todo_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into todo_list (name, pos, ",
        "owner, time, last_update_time, ",
        "group, status, undertaker_list)",
        "values (#{name,jdbcType=VARCHAR}, #{pos,jdbcType=VARCHAR}, ",
        "#{owner,jdbcType=INTEGER}, #{time,jdbcType=VARCHAR}, #{lastUpdateTime,jdbcType=VARCHAR}, ",
        "#{group,jdbcType=INTEGER}, #{status,jdbcType=VARCHAR}, #{undertakerList,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TodoList record);

    @InsertProvider(type=TodoListSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(TodoList record);

    @SelectProvider(type=TodoListSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pos", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="owner", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="last_update_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="group", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="undertaker_list", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TodoList> selectByExample(TodoListExample example);

    @Select({
        "select",
        "id, name, pos, owner, time, last_update_time, group, status, undertaker_list",
        "from todo_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pos", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="owner", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="last_update_time", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="group", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="undertaker_list", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TodoList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TodoListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TodoList record, @Param("example") TodoListExample example);

    @UpdateProvider(type=TodoListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TodoList record, @Param("example") TodoListExample example);

    @UpdateProvider(type=TodoListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TodoList record);

    @Update({
        "update todo_list",
        "set name = #{name,jdbcType=VARCHAR},",
          "pos = #{pos,jdbcType=VARCHAR},",
          "owner = #{owner,jdbcType=INTEGER},",
          "time = #{time,jdbcType=VARCHAR},",
          "last_update_time = #{lastUpdateTime,jdbcType=VARCHAR},",
          "group = #{group,jdbcType=INTEGER},",
          "status = #{status,jdbcType=VARCHAR},",
          "undertaker_list = #{undertakerList,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TodoList record);
}