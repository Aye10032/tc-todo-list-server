package com.aye10032.tctodolist.tctodolistserver.pojo;

/**
 * @author Aye10032
 * @date 2022-02-11
 */
public class Task {
    private Integer id;

    private String name;

    private String pos;

    private Integer owner;

    private Long time;

    private Long lastUpdateTime;

    private Integer group;

    private Boolean status;

    private String undertakerList;

    public Task(Integer id, String name, String pos, Integer owner, Long time, Long lastUpdateTime, Integer group, Boolean status, String undertakerList) {
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

    public Task() {
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUndertakerList() {
        return undertakerList;
    }

    public void setUndertakerList(String undertakerList) {
        this.undertakerList = undertakerList;
    }
}