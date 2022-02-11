package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface GroupMapper {
    @SelectProvider(type=GroupSqlProvider.class, method="countByExample")
    long countByExample(GroupExample example);

    @DeleteProvider(type=GroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(GroupExample example);

    @Delete({
        "delete from todo_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into todo_group (owner, admins)",
        "values (#{owner,jdbcType=INTEGER}, #{admins,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler})"
    })
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Group record);

    @InsertProvider(type=GroupSqlProvider.class, method="insertSelective")
    @SelectKey(statement="select last_insert_rowid()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Group record);

    @SelectProvider(type=GroupSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="owner", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="admins", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    List<Group> selectByExample(GroupExample example);

    @Select({
        "select",
        "id, owner, admins",
        "from todo_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="owner", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="admins", javaType=List.class, typeHandler=ListToVarcharTypeHandler.class, jdbcType=JdbcType.VARCHAR)
    })
    Group selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    @UpdateProvider(type=GroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

    @UpdateProvider(type=GroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Group record);

    @Update({
        "update todo_group",
        "set owner = #{owner,jdbcType=INTEGER},",
          "admins = #{admins,jdbcType=VARCHAR,typeHandler=com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Group record);
}