package com.aye10032.tctodolist.tctodolistserver.dao;

import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: IPlayerDao
 * @Description: player dao接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 10:49
 */
@Mapper
public interface IPlayerDao {

    @Select("SELECT count(*) FROM sqlite_master WHERE type=\"table\" AND name = \"player_list\"")
    Integer PlayerTableExist();

    @Update("create table player_list\n" +
            "(\n" +
            "\tid INTEGER not null\n" +
            "\t\tconstraint todo_list_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\tname TEXT not null,\n" +
            "\tuuid TEXT not null,\n" +
            "\top BLOB not null,\n" +
            "\tgroups BLOB\n" +
            ");")
    void createPlayerTable();

    @Insert("INSERT INTO player_list" +
            "('name','uuid','op','groups') VALUES " +
            "(#{name}, #{uuid}, #{op}, #{groups});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer insertPlayer(PlayerPojo player);

    @Select("SELECT * FROM player_list WHERE id=#{id}")
    List<PlayerPojo> selectPlayerByID(Integer id);

    @Select("SELECT * FROM player_list WHERE name=#{name}")
    List<PlayerPojo> selectPlayerByName(String name);

    @Select("SELECT * FROM player_list WHERE uuid=#{uuid}")
    List<PlayerPojo> selectPlayerByUUID(String uuid);

    @Update("UPDATE player_list SET " +
            "name=#{name}, op=#{op}, groups=#{groups} WHERE uuid=#{uuid}")
    void updatePlayerByUUID(PlayerPojo player);

    @Update("UPDATE player_list SET " +
            "name=#{name}, op=#{op}, groups=#{groups} WHERE id=#{id}")
    void updatePlayerByID(PlayerPojo player);

}
