package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: tc-todo-list-server
 * @className: PlayerPojo
 * @Description: 玩家实体类
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/9 下午 5:46
 */

@Data
@NoArgsConstructor
@ApiModel("玩家信息")
public class PlayerPojo {

    private Integer id;

    @ApiModelProperty("玩家ID")
    @NotNull(message = "player must have name")
    private String name;

    @ApiModelProperty("玩家UUID")
    @NotBlank(message = "player must have correct uuid")
    private String uuid;

    @ApiModelProperty("玩家是否是管理员")
    @NotNull(message = "must be told if player is admin")
    private Boolean op;

    @ApiModelProperty("玩家所属组")
    // @TableField(value = "groups", typeHandler = com.aye10032.tctodolist.tctodolistserver.handler.ListToVarcharTypeHandler.class)
    private List<Integer> groups;

    public PlayerPojo(String name, String uuid, boolean op){
        setName(name);
        setUuid(uuid);
        setOp(op);

        List<Integer> group = new ArrayList<>();
        group.add(1);
        setGroups(group);
    }

}
