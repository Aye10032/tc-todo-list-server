package com.aye10032.tctodolist.tctodolistserver.config;

import com.aye10032.tctodolist.tctodolistserver.dao.ITodoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * @author Dazo66
 */
@Configuration
@Slf4j
public class SqliteConfig {

    @Autowired
    private ITodoDao todoDao;

    @Value("${spring.datasource.url}")
    private String sqliteUrl;

    @PostConstruct
    public void init() {
        if (!StringUtils.isEmpty(sqliteUrl)
                && !new File(sqliteUrl.replace("jdbc:sqlite:", "")).exists()) {
            todoDao.CreateTodoTable();
            log.info("表初始化成功");
        }
    }

}
