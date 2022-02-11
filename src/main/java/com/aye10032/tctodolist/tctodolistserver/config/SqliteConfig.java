package com.aye10032.tctodolist.tctodolistserver.config;

import com.aye10032.tctodolist.tctodolistserver.dao.*;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupPojo;
import com.aye10032.tctodolist.tctodolistserver.pojo.PlayerPojo;
import com.aye10032.tctodolist.tctodolistserver.util.MinecraftUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
            PlayerInit();
            log.info("表初始化成功");
        } else if (!StringUtils.isEmpty(sqliteUrl)
                && new File(sqliteUrl.replace("jdbc:sqlite:", "")).exists()) {
            if (groupDao.GroupTableExist() == 0) {
                groupDao.CreateGroupTable();
                GroupInit();
            }
            if (messageDao.MessageTableExist() == 0) {
                messageDao.CreateMessageTable();
            }
            if (playerDao.PlayerTableExist() == 0) {
                playerDao.createPlayerTable();
                PlayerInit();
            }
            if (todoDao.TodoTableExist() == 0) {
                todoDao.CreateTodoTable();
            }
            if (undertakeDao.UndertakeTableExist() == 0) {
                undertakeDao.CreateUndertakeTable();
            }
            log.info("表加载成功");
        }
    }

    //设置初始管理员
    private void PlayerInit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("type ID of admin(split with space):");

        List<String> admins = new ArrayList<>();
        if (scanner.hasNextLine()) {
            String[] admin_arr = scanner.nextLine().split(" ");
            admins = Arrays.stream(admin_arr).collect(Collectors.toList());
        }
        if (!admins.isEmpty()) {
            System.out.println("input: " + Arrays.toString(admins.toArray()));
            for (String name : admins) {
                PlayerPojo player = new PlayerPojo(name, MinecraftUtil.getUUID(name), true);
                playerDao.insertPlayer(player);
            }
        }
        scanner.close();
    }

    //创建服务器默认组
    private void GroupInit() {
        GroupPojo group = new GroupPojo();

        //没有创建者
        group.setOwner(-1);

        List<Integer> admins = new ArrayList<>();
        group.setAdmins(admins);

        groupDao.insertGroup(group);
    }

}
