package com.aye10032.tctodolist.tctodolistserver.handler;

import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.data.ResultCode;
import com.aye10032.tctodolist.tctodolistserver.data.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @program: tc-todo-list-server
 * @className: ExceptionControllerAdvice
 * @Description: 异常处理
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 11:26
 */
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {

        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);

        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMsg());
    }

}
