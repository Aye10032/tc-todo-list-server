package com.aye10032.tctodolist.tctodolistserver.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Aye10032
 * @date 2022-02-11
 */
@ApiModel("组信息")
public class Group {

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "组创建人", required = true)
    private Integer owner;

    @ApiModelProperty(value = "组名称(唯一)", required = true)
    private String name;

    @ApiModelProperty(value = "组简介")
    private String information;

    @ApiModelProperty(value = "组管理员列表")
    private List admins;

    public Group(Integer id, Integer owner, String name, String information, List admins) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.information = information;
        this.admins = admins;
    }

    public Group() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List getAdmins() {
        return admins;
    }

    public void setAdmins(List admins) {
        this.admins = admins;
    }
}