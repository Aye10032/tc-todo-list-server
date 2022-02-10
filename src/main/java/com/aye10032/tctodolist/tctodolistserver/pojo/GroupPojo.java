package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: GroupPojo
 * @Description: 组实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 9:44
 */

@Data
@NoArgsConstructor
@ApiModel("组信息")
public class GroupPojo {

    private Integer id;

    @ApiModelProperty("组创建人")
    @NotNull(message = "group must have owner")
    private Integer owner;

    @ApiModelProperty("组管理员")
    //@TableField(value = "admins", typeHandler = com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler.class)
    private List<Integer> admins;

}
