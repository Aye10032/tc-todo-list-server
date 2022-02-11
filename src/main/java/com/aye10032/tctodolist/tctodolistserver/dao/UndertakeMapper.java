package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.Undertake;
import com.aye10032.tctodolist.tctodolistserver.pojo.UndertakeExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UndertakeMapper {
    @SelectProvider(type = UndertakeSqlProvider.class, method = "countByExample")
    long countByExample(UndertakeExample example);

    @DeleteProvider(type = UndertakeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(UndertakeExample example);

    @Delete({
            "delete from todo_undertake",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into todo_undertake (player_id, msg, ",
            "time, last_update_time)",
            "values (#{playerId,jdbcType=INTEGER}, #{msg,jdbcType=VARCHAR}, ",
            "#{time,jdbcType=NUMERIC}, #{lastUpdateTime,jdbcType=NUMERIC})"
    })
    @SelectKey(statement = "select last_insert_rowid()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Undertake record);

    @InsertProvider(type = UndertakeSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "select last_insert_rowid()", keyProperty = "id", before = false, resultType = Integer.class)
    int insertSelective(Undertake record);

    @SelectProvider(type = UndertakeSqlProvider.class, method = "selectByExample")
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "player_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "msg", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Long.class, jdbcType = JdbcType.NUMERIC),
            @Arg(column = "last_update_time", javaType = Long.class, jdbcType = JdbcType.NUMERIC)
    })
    List<Undertake> selectByExample(UndertakeExample example);

    @Select({
            "select",
            "id, player_id, msg, time, last_update_time",
            "from todo_undertake",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
            @Arg(column = "id", javaType = Integer.class, jdbcType = JdbcType.INTEGER, id = true),
            @Arg(column = "player_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Arg(column = "msg", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Arg(column = "time", javaType = Long.class, jdbcType = JdbcType.NUMERIC),
            @Arg(column = "last_update_time", javaType = Long.class, jdbcType = JdbcType.NUMERIC)
    })
    Undertake selectByPrimaryKey(Integer id);

    @UpdateProvider(type = UndertakeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Undertake record, @Param("example") UndertakeExample example);

    @UpdateProvider(type = UndertakeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") Undertake record, @Param("example") UndertakeExample example);

    @UpdateProvider(type = UndertakeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Undertake record);

    @Update({
            "update todo_undertake",
            "set player_id = #{playerId,jdbcType=INTEGER},",
            "msg = #{msg,jdbcType=VARCHAR},",
            "time = #{time,jdbcType=NUMERIC},",
            "last_update_time = #{lastUpdateTime,jdbcType=NUMERIC}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Undertake record);
}