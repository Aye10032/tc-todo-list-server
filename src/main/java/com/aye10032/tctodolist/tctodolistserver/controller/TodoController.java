package com.aye10032.tctodolist.tctodolistserver.controller;

import com.aye10032.tctodolist.tctodolistserver.data.ResultVO;
import com.aye10032.tctodolist.tctodolistserver.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller 由Controller层对服务层的结果进行包装后返回
 * @author Dazo66
 */
@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("exist")
    public Boolean doesTableExist() {
        return todoService.doesTableExist();
    }

}
