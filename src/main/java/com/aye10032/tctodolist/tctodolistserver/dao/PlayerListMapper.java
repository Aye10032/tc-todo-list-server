package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerList;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerListExample;
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
public interface PlayerListMapper {
    @SelectProvider(type=PlayerListSqlProvider.class, method="countByExample")
    long countByExample(PlayerListExample example);

    @DeleteProvider(type=PlayerListSqlProvider.class, method="deleteByExample")
    int deleteByExample(PlayerListExample example);

    @Delete({
        "delete from player_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into player_list (name, uuid, ",
        "op, groups)",
        "values (#{name,jdbcType=VARCHAR}, #{uuid,jdbcType=VARCHAR}, ",
        "#{op,jdbcType=VARCHAR}, #{groups,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PlayerList record);

    @InsertProvider(type=PlayerListSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PlayerList record);

    @SelectProvider(type=PlayerListSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uuid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="op", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="groups", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    List<PlayerList> selectByExample(PlayerListExample example);

    @Select({
        "select",
        "id, name, uuid, op, groups",
        "from player_list",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="uuid", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="op", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="groups", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    PlayerList selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PlayerListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PlayerList record, @Param("example") PlayerListExample example);

    @UpdateProvider(type=PlayerListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PlayerList record, @Param("example") PlayerListExample example);

    @UpdateProvider(type=PlayerListSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PlayerList record);

    @Update({
        "update player_list",
        "set name = #{name,jdbcType=VARCHAR},",
          "uuid = #{uuid,jdbcType=VARCHAR},",
          "op = #{op,jdbcType=VARCHAR},",
          "groups = #{groups,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PlayerList record);
}