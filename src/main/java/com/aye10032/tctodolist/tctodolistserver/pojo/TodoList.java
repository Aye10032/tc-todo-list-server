package com.aye10032.tctodolist.tctodolistserver.pojo;

/**
 * @author dazo66
 * @date 2022-02-10
 */
public class TodoList {
    private Integer id;

    private String name;

    private String pos;

    private Integer owner;

    private String time;

    private String lastUpdateTime;

    private Integer group;

    private String status;

    private String undertakerList;

    public TodoList(Integer id, String name, String pos, Integer owner, String time, String lastUpdateTime, Integer group, String status, String undertakerList) {
        this.id = id;
        this.name = name;
        this.pos = pos;
        this.owner = owner;
        this.time = time;
        this.lastUpdateTime = lastUpdateTime;
        this.group = group;
        this.status = status;
        this.undertakerList = undertakerList;
    }

    public TodoList() {
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

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUndertakerList() {
        return undertakerList;
    }

    public void setUndertakerList(String undertakerList) {
        this.undertakerList = undertakerList;
    }
}