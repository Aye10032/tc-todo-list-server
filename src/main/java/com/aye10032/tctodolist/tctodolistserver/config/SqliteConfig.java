package com.aye10032.tctodolist.tctodolistserver.config;

import com.aye10032.tctodolist.tctodolistserver.dao.*;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.util.MinecraftUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.File;
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
    private GroupMapper groupMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private PlayerMapper playerMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private UndertakeMapper undertakeMapper;

    @Value("${spring.datasource.url}")
    private String sqliteUrl;

    @PostConstruct
    public void init() {
        if (!StringUtils.isEmpty(sqliteUrl)
                && new File(sqliteUrl.replace("jdbc:sqlite:", "")).exists()) {
            GroupExample groupExample = new GroupExample();
            groupExample.createCriteria();
            if (groupMapper.countByExample(groupExample) == 0) {
                GroupInit();
                log.info("已添加默认组");
                PlayerInit();
            }
            log.info("表初始化成功");
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
                String uuid;
                try {
                    uuid = MinecraftUtil.getUUID(name);
                    Player player = new Player();
                    player.setName(name);
                    player.setUuid(uuid);
                    player.setAdmin(true);

                    List<Integer> groups = new ArrayList<>();
                    groups.add(1);
                    player.setGroups(groups);

                    playerMapper.insert(player);
                } catch (APIException e) {
                    log.error("skip " + name + " because of wrong ID");
                }
            }
        }
        scanner.close();
    }

    //创建服务器默认组
    private void GroupInit() {
        Group group = new Group();

        //没有创建者
        group.setOwner(-1);

        List<Integer> admins = new ArrayList<>();
        group.setAdmins(admins);

        groupMapper.insert(group);
    }

}
