package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.GroupMapper;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Group;
import com.aye10032.tctodolist.tctodolistserver.pojo.GroupExample;
import com.aye10032.tctodolist.tctodolistserver.pojo.Player;
import com.aye10032.tctodolist.tctodolistserver.service.GroupService;
import com.aye10032.tctodolist.tctodolistserver.service.PlayerService;
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
    public Group getGroupById(Integer id) {
        GroupExample example = new GroupExample();
        example.createCriteria().andIdEqualTo(id);
        List<Group> groupList = groupMapper.selectByExample(example);
        return groupList.isEmpty() ? null : groupList.get(0);
    }

    @Override
    public Group getGroupByName(String name) {
        GroupExample example = new GroupExample();
        example.createCriteria().andNameEqualTo(name);
        List<Group> groupList = groupMapper.selectByExample(example);
        return groupList.isEmpty() ? null : groupList.get(0);
    }

    @Override
    public Integer insertGroup(Integer owner_id, String name, String information) {
        GroupExample example = new GroupExample();
        example.createCriteria().andNameEqualTo(name);
        if (groupMapper.countByExample(example) == 0) {
            Group group = new Group();
            group.setOwner(owner_id);
            group.setName(name);
            group.setInformation(information);

            List<Integer> admins = new ArrayList<>();
            admins.add(owner_id);
            group.setAdmins(admins);
            groupMapper.insert(group);
            return group.getId();
        } else {
            throw new APIException("group doesn't exists!");
        }
    }

    @Override
    public void insertAdmin(Integer group_id, Integer admin_id) {
        Group group = getGroupById(group_id);
        List<Integer> admins = group.getAdmins();
        if (!admins.contains(admin_id)) {
            admins.add(admin_id);
            group.setAdmins(admins);
            GroupExample example = new GroupExample();
            example.createCriteria().andIdEqualTo(group_id);
            groupMapper.updateByExample(group, example);
        } else {
            throw new APIException("player is already an administrator");
        }
    }
}
