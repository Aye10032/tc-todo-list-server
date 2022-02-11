package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.GroupMapper;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: GroupServiceImpl
 * @Description: group服务层接口实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/11 下午 4:44
 */
@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupMapper groupMapper;

    @Override
    public void insertGroup(Integer owner_id) {
        Group group = new Group();
        group.setOwner(owner_id);

        List<Integer> admins = new ArrayList<>();
        group.setAdmins(admins);

        groupMapper.insert(group);
    }

    @Override
    public void insertAdmin() {

    }
}
