package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Aye10032
 * @date 2022-02-12
 */
@ApiModel("任务信息")
public class Task {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "任务名称", required = true)
    private String name;

    @ApiModelProperty(value = "任务关键点坐标", required = true)
    private String pos;

    @ApiModelProperty(value = "任务创建人", required = true)
    private Integer owner;

    @ApiModelProperty(value = "任务创建时间", required = true)
    private Long time;

    @ApiModelProperty(value = "任务最后留言更新时间", required = true)
    private Long lastUpdateTime;

    @ApiModelProperty(value = "任务所属组(留空则默认为服务器组)")
    private Integer groups;

    @ApiModelProperty(value = "任务完成状态")
    private Boolean status;

    @ApiModelProperty(value = "任务承接玩家列表")
    private List undertakerList;

    public Task(Integer id, String name, String pos, Integer owner, Long time, Long lastUpdateTime, Integer groups, Boolean status, List undertakerList) {
        this.id = id;
        this.name = name;
        this.pos = pos;
        this.owner = owner;
        this.time = time;
        this.lastUpdateTime = lastUpdateTime;
        this.groups = groups;
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

    public Integer getGroups() {
        return groups;
    }

    public void setGroups(Integer groups) {
        this.groups = groups;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List getUndertakerList() {
        return undertakerList;
    }

    public void setUndertakerList(List undertakerList) {
        this.undertakerList = undertakerList;
    }
}