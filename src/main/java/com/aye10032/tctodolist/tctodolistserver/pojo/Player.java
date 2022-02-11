package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author Aye10032
 * @date 2022-02-11
 */
@ApiModel("玩家信息")
public class Player {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "玩家ID", required = true)
    private String name;

    @ApiModelProperty(value = "玩家UUID", required = true)
    private String uuid;

    @ApiModelProperty(value = "玩家管理员权限")
    private Boolean admin;

    @ApiModelProperty(value = "玩家所属组")
    private List groups;

    public Player(Integer id, String name, String uuid, Boolean admin, List groups) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.admin = admin;
        this.groups = groups;
    }

    public Player() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List getGroups() {
        return groups;
    }

    public void setGroups(List groups) {
        this.groups = groups;
    }
}