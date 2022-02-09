package com.aye10032.tctodolist.tctodolistserver.data;

import lombok.Getter;

/**
 * @program: tc-todo-list-server
 * @className: ResultVO
 * @Description: 返回体
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 11:27
 */
@Getter
public class ResultVO<T> {

    private int code;
    private String msg;
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

}
