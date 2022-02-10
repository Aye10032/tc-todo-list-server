package com.aye10032.tctodolist.tctodolistserver.config;

import com.aye10032.tctodolist.tctodolistserver.dao.*;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupPojo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dazo66
 */
@Configuration
@Slf4j
public class SqliteConfig {

    @Autowired
    private IGroupDao groupDao;
    @Autowired
    private IMessageDao messageDao;
    @Autowired
    private IPlayerDao playerDao;
    @Autowired
    private ITodoDao todoDao;
    @Autowired
    private IUndertakeDao undertakeDao;

    @Value("${spring.datasource.url}")
    private String sqliteUrl;

    @PostConstruct
    public void init() {
        if (!StringUtils.isEmpty(sqliteUrl)
                && !new File(sqliteUrl.replace("jdbc:sqlite:", "")).exists()) {
            groupDao.CreateGroupTable();
            messageDao.CreateMessageTable();
            playerDao.createPlayerTable();
            todoDao.CreateTodoTable();
            undertakeDao.CreateUndertakeTable();

            GroupInit();
            log.info("表初始化成功");
        }else if (!StringUtils.isEmpty(sqliteUrl)
                && new File(sqliteUrl.replace("jdbc:sqlite:", "")).exists()){
            if (groupDao.GroupTableExist() == 0){
                groupDao.CreateGroupTable();
                GroupInit();
            }
            if (messageDao.MessageTableExist() == 0){
                messageDao.CreateMessageTable();
            }
            if (playerDao.PlayerTableExist() == 0){
                playerDao.createPlayerTable();
            }
            if (todoDao.TodoTableExist() == 0){
                todoDao.CreateTodoTable();
            }
            if (undertakeDao.UndertakeTableExist() == 0){
                undertakeDao.CreateUndertakeTable();
            }
            log.info("表加载成功");
        }
    }

    //创建服务器默认组
    private void GroupInit(){
        GroupPojo group = new GroupPojo();

        //没有创建者
        group.setOwner(-1);

        List<Integer> admins = new ArrayList<>();
        group.setAdmins(admins);

        groupDao.insertGroup(group);
    }

}
