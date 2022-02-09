package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: tc-todo-list-server
 * @className: UndertakePojo
 * @Description: 任务承接实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 10:11
 */

@Data
@NoArgsConstructor
@ApiModel("任务承接信息")
public class UndertakePojo {

    private Integer id;

    @ApiModelProperty("任务承接玩家ID")
    @NotNull(message = "must have undertake player")
    private Integer player_id;

    @ApiModelProperty("任务承接玩家留言")
    private String msg;

    @ApiModelProperty("任务承接时间")
    @NotNull(message = "must have undertake time")
    private Long time;

    @ApiModelProperty("玩家留言更新时间")
    private Long last_update_time;

}
