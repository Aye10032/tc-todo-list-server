package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
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
    @NotNull(message = "player must have uuid")
    private String uuid;

    @ApiModelProperty("玩家是否是管理员")
    @NotNull(message = "must be told if player is admin")
    private Boolean op;

    @ApiModelProperty("玩家所属组")
    private List<Integer> groups;

}
