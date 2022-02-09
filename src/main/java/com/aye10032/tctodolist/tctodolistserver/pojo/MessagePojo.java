package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @program: tc-todo-list-server
 * @className: MessagePojo
 * @Description: 留言实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 9:51
 */

@Data
@NoArgsConstructor
@ApiModel("留言信息")
public class MessagePojo {

    private Integer id;

    @ApiModelProperty("发送留言的玩家ID")
    @NotNull(message = "massage must have information about from which player")
    private Integer from_player;

    @ApiModelProperty("留言目的玩家ID")
    @NotNull(message = "massage must have target player")
    private Integer target_player;

    @ApiModelProperty("留言发送时间")
    @NotNull(message = "massage must have send time")
    private Long send_time;

    @ApiModelProperty("留言最后更新时间")
    @NotNull(message = "massage must have last update time")
    private Long last_update_time;

    @ApiModelProperty("留言内容")
    @NotNull(message = "massage must have content")
    private String msg;

    @ApiModelProperty("留言已读状态")
    @NotNull(message = "massage must have information about have read")
    private Boolean has_read;

    @ApiModelProperty("留言来自哪个任务（没有则为单纯留言）")
    private Integer from_todo;

}
