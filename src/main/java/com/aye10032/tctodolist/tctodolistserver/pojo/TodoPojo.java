package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: TodoPojo
 * @Description: 任务实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 上午 10:50
 */

@Data
@NoArgsConstructor
@ApiModel("任务信息")
public class TodoPojo {

    private Integer id;

    @ApiModelProperty("任务简介")
    @NotNull(message = "task must have name")
    private String name;

    @ApiModelProperty("任务关键点坐标")
    private String pos;

    @ApiModelProperty("任务创建人")
    @NotNull(message = "task must have owner")
    private Integer owner;

    @ApiModelProperty("任务创建时间")
    @NotNull(message = "task must have time")
    private Long time;

    @ApiModelProperty("任务最后更新时间")
    @NotNull(message = "task must have last update time")
    private Long last_update_time;

    @ApiModelProperty("任务所属分组")
    @NotNull(message = "task must have group")
    private Integer group;

    @ApiModelProperty("任务状态")
    @NotNull(message = "task must have status")
    private Boolean status;

    @ApiModelProperty("任务承接信息")
    private List<Integer> undertaker_list;
}
