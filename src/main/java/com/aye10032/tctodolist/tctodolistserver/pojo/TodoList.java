package com.aye10032.tctodolist.tctodolistserver.pojo;

/**
 * @author dazo66
 * @date 2022-02-11
 */
public class TodoList {
    private Integer id;

    private Integer fromPlayer;

    private Integer targetPlayer;

    private Long sendTime;

    private Long lastUpdateTime;

    private String msg;

    private Integer hasRead;

    private Integer fromTodo;

    public TodoList(Integer id, Integer fromPlayer, Integer targetPlayer, Long sendTime, Long lastUpdateTime, String msg, Integer hasRead, Integer fromTodo) {
        this.id = id;
        this.fromPlayer = fromPlayer;
        this.targetPlayer = targetPlayer;
        this.sendTime = sendTime;
        this.lastUpdateTime = lastUpdateTime;
        this.msg = msg;
        this.hasRead = hasRead;
        this.fromTodo = fromTodo;
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

    public Integer getHasRead() {
        return hasRead;
    }

    public void setHasRead(Integer hasRead) {
        this.hasRead = hasRead;
    }

    public Integer getFromTodo() {
        return fromTodo;
    }

    public void setFromTodo(Integer fromTodo) {
        this.fromTodo = fromTodo;
    }
}