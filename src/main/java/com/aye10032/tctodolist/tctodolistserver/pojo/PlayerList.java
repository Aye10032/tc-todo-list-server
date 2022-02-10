package com.aye10032.tctodolist.tctodolistserver.pojo;

import java.util.List;

/**
 * @author dazo66
 * @date 2022-02-10
 */
public class PlayerList {
    private Integer id;

    private String name;

    private String uuid;

    private String op;

    private List groups;

    public PlayerList(Integer id, String name, String uuid, String op, List groups) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.op = op;
        this.groups = groups;
    }

    public PlayerList() {
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

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public List getGroups() {
        return groups;
    }

    public void setGroups(List groups) {
        this.groups = groups;
    }
}