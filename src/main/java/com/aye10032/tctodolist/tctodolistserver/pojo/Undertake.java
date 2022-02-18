package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Aye10032
 * @date 2022-02-15
 */
@ApiModel("承接信息")
public class Undertake {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "玩家ID")
    private Integer playerId;

    @ApiModelProperty(value = "玩家留言")
    private String msg;

    @ApiModelProperty(value = "承接时间")
    private Long time;

    @ApiModelProperty(value = "最后更新时间")
    private Long lastUpdateTime;

    @ApiModelProperty(value = "承接任务ID")
    private Integer fromTask;

    public Undertake(Integer id, Integer playerId, String msg, Long time, Long lastUpdateTime, Integer fromTask) {
        this.id = id;
        this.playerId = playerId;
        this.msg = msg;
        this.time = time;
        this.lastUpdateTime = lastUpdateTime;
        this.fromTask = fromTask;
    }

    public Undertake() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public Integer getFromTask() {
        return fromTask;
    }

    public void setFromTask(Integer fromTask) {
        this.fromTask = fromTask;
    }
}