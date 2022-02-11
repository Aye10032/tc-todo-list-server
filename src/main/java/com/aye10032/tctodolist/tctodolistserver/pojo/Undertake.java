package com.aye10032.tctodolist.tctodolistserver.pojo;

/**
 * @author Aye10032
 * @date 2022-02-11
 */
public class Undertake {
    private Integer id;

    private Integer playerId;

    private String msg;

    private Long time;

    private Long lastUpdateTime;

    public Undertake(Integer id, Integer playerId, String msg, Long time, Long lastUpdateTime) {
        this.id = id;
        this.playerId = playerId;
        this.msg = msg;
        this.time = time;
        this.lastUpdateTime = lastUpdateTime;
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
}