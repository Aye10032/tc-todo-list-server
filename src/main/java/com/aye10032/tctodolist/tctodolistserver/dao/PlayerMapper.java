package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface PlayerMapper {
    @SelectProvider(type=PlayerSqlProvider.class, method="countByExample")
    long countByExample(PlayerExample example);

    @DeleteProvider(type=PlayerSqlProvider.class, method="deleteByExample")
    int deleteByExample(PlayerExample example);

    @Delete({
        "delete from todo_player",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into todo_player (name, uuid, ",
        "admin, groups)",
        "values (#{name,jdbcType=VARCHAR}, #{uuid,jdbcType=VARCHAR}, ",
        "#{admin,jdbcType=BOOLEAN}, #{groups,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Player record);

    @InsertProvider(type=PlayerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Player record);

    @SelectProvider(type=PlayerSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uuid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="admin", javaType=Boolean.class, jdbcType=JdbcType.BOOLEAN),
        @Arg(column="groups", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Player> selectByExample(PlayerExample example);

    @Select({
        "select",
        "id, name, uuid, admin, groups",
        "from todo_player",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uuid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="admin", javaType=Boolean.class, jdbcType=JdbcType.BOOLEAN),
        @Arg(column="groups", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    Player selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PlayerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Player record, @Param("example") PlayerExample example);

    @UpdateProvider(type=PlayerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Player record, @Param("example") PlayerExample example);

    @UpdateProvider(type=PlayerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Player record);

    @Update({
        "update todo_player",
        "set name = #{name,jdbcType=VARCHAR},",
          "uuid = #{uuid,jdbcType=VARCHAR},",
          "admin = #{admin,jdbcType=BOOLEAN},",
          "groups = #{groups,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Player record);
}