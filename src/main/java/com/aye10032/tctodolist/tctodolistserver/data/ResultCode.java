package com.aye10032.tctodolist.tctodolistserver.data;

import lombok.Getter;

/**
 * @program: tc-todo-list-server
 * @className: ResultCode
 * @Description: 响应码
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 11:27
 */
@Getter
public enum ResultCode {

    SUCCESS(1000, "操作成功"),
    FAILED(1001, "响应失败"),
    VALIDATE_FAILED(1002, "参数校验失败"),
    ERROR(5000, "未知错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
