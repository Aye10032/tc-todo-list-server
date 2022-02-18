package com.aye10032.tctodolist.tctodolistserver.service.impl;

import com.aye10032.tctodolist.tctodolistserver.dao.UndertakeMapper;
import com.aye10032.tctodolist.tctodolistserver.data.APIException;
import com.aye10032.tctodolist.tctodolistserver.pojo.Undertake;
import com.aye10032.tctodolist.tctodolistserver.pojo.UndertakeExample;
import com.aye10032.tctodolist.tctodolistserver.service.UndertakeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: tc-todo-list-server
 * @className: UndertakeServiceImpl
 * @Description: undertake service接口实现
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/16 上午 11:08
 */
@Service
public class UndertakeServiceImpl implements UndertakeService {

    @Autowired
    UndertakeMapper undertakeMapper;

    @Override
    public Integer insertUndertake(Integer task_id, Integer player_id, String msg) {
        UndertakeExample example = new UndertakeExample();
        example.createCriteria().andFromTaskEqualTo(task_id).andPlayerIdEqualTo(player_id);
        if (undertakeMapper.countByExample(example) == 0) {
            Undertake undertake = new Undertake();
            undertake.setFromTask(task_id);
            undertake.setPlayerId(player_id);
            if (StringUtils.isNotBlank(msg)) {
                undertake.setMsg(msg);
            } else {
                undertake.setMsg("");
            }
            Date date = new Date();
            undertake.setTime(date.getTime());
            undertake.setLastUpdateTime(date.getTime());
            undertakeMapper.insert(undertake);
            return undertake.getId();
        }else {
            throw new APIException("already undertake this task!");
        }
    }
}
