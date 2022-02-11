package com.aye10032.tctodolist.tctodolistserver.pojo;

import java.util.List;

/**
 * @author Aye10032
 * @date 2022-02-11
 */
public class Player {
    private Integer id;

    private String name;

    private String uuid;

    private Integer admin;

    private List groups;

    public Player(Integer id, String name, String uuid, Integer admin, List groups) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.admin = admin;
        this.groups = groups;
    }

    public Player() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public List getGroups() {
        return groups;
    }

    public void setGroups(List groups) {
        this.groups = groups;
    }
}