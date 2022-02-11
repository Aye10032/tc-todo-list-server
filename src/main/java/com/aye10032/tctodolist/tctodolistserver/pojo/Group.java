package com.aye10032.tctodolist.tctodolistserver.pojo;

import java.util.List;

/**
 * @author Aye10032
 * @date 2022-02-11
 */
public class Group {
    private Integer id;

    private Integer owner;

    private List admins;

    public Group(Integer id, Integer owner, List admins) {
        this.id = id;
        this.owner = owner;
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

    public List getAdmins() {
        return admins;
    }

    public void setAdmins(List admins) {
        this.admins = admins;
    }
}