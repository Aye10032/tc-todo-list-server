package com.aye10032.tctodolist.tctodolistserver.pojo;

/**
 * @author Aye10032
 * @date 2022-02-15
 */
public class Message {
    private Integer id;

    private Integer fromPlayer;

    private Integer targetPlayer;

    private Long sendTime;

    private Long lastUpdateTime;

    private String msg;

    private Boolean hasRead;

    private Integer fromTask;

    public Message(Integer id, Integer fromPlayer, Integer targetPlayer, Long sendTime, Long lastUpdateTime, String msg, Boolean hasRead, Integer fromTask) {
        this.id = id;
        this.fromPlayer = fromPlayer;
        this.targetPlayer = targetPlayer;
        this.sendTime = sendTime;
        this.lastUpdateTime = lastUpdateTime;
        this.msg = msg;
        this.hasRead = hasRead;
        this.fromTask = fromTask;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromPlayer() {
        return fromPlayer;
    }

    public void setFromPlayer(Integer fromPlayer) {
        this.fromPlayer = fromPlayer;
    }

    public Integer getTargetPlayer() {
        return targetPlayer;
    }

    public void setTargetPlayer(Integer targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getHasRead() {
        return hasRead;
    }

    public void setHasRead(Boolean hasRead) {
        this.hasRead = hasRead;
    }

    public Integer getFromTask() {
        return fromTask;
    }

    public void setFromTask(Integer fromTask) {
        this.fromTask = fromTask;
    }
}