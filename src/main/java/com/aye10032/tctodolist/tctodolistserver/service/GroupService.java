package com.aye10032.tctodolist.tctodolistserver.service;

import com.aye10032.tctodolist.tctodolistserver.pojo.Group;

/**
 * @program: tc-todo-list-server
 * @className: GroupService
 * @Description: group服务层接口
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/11 下午 4:27
 */
public interface GroupService {

    Group getGroupById(Integer id);

    Group getGroupByName(String name);

    Integer insertGroup(Integer owner_id, String name, String information);

    void insertAdmin(Integer group_id, Integer admin_id);

    void deleteAdmin(Integer group_id, Integer admin_id);

}
