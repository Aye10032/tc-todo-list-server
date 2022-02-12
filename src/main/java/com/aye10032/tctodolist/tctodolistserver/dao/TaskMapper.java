package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler;
import com.aye10032.tctodolist.tctodolistserver.pojo.Task;
import com.aye10032.tctodolist.tctodolistserver.pojo.TaskExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface TaskMapper {
    @SelectProvider(type=TaskSqlProvider.class, method="countByExample")
    long countByExample(TaskExample example);

    @DeleteProvider(type=TaskSqlProvider.class, method="deleteByExample")
    int deleteByExample(TaskExample example);

    @Delete({
        "delete from todo_task",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into todo_task (name, pos, ",
        "owner, time, last_update_time, ",
        "groups, status, ",
        "undertaker_list)",
        "values (#{name,jdbcType=VARCHAR}, #{pos,jdbcType=VARCHAR}, ",
        "#{owner,jdbcType=INTEGER}, #{time,jdbcType=NUMERIC}, #{lastUpdateTime,jdbcType=NUMERIC}, ",
        "#{groups,jdbcType=INTEGER}, #{status,jdbcType=BOOLEAN}, ",
        "#{undertakerList,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Task record);

    @InsertProvider(type=TaskSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Task record);

    @SelectProvider(type=TaskSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pos", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="owner", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="last_update_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="groups", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="status", javaType=Boolean.class, jdbcType=JdbcType.BOOLEAN),
        @Arg(column="undertaker_list", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Task> selectByExample(TaskExample example);

    @Select({
        "select",
        "id, name, pos, owner, time, last_update_time, groups, status, undertaker_list",
        "from todo_task",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="pos", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="owner", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="last_update_time", javaType=Long.class, jdbcType=JdbcType.NUMERIC),
        @Arg(column="groups", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="status", javaType=Boolean.class, jdbcType=JdbcType.BOOLEAN),
        @Arg(column="undertaker_list", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    Task selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    @UpdateProvider(type=TaskSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Task record);

    @Update({
        "update todo_task",
        "set name = #{name,jdbcType=VARCHAR},",
          "pos = #{pos,jdbcType=VARCHAR},",
          "owner = #{owner,jdbcType=INTEGER},",
          "time = #{time,jdbcType=NUMERIC},",
          "last_update_time = #{lastUpdateTime,jdbcType=NUMERIC},",
          "groups = #{groups,jdbcType=INTEGER},",
          "status = #{status,jdbcType=BOOLEAN},",
          "undertaker_list = #{undertakerList,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Task record);
}