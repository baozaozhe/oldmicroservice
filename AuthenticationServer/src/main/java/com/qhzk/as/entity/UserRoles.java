package com.qhzk.as.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @description: 用户角色信息
 * @author: Mr.Muxl
 * @create: 2021-08-06 17:10
 **/
@ApiModel(value = "用户角色信息")
public class UserRoles {
    @ApiModelProperty(value = "用户组角色")
    private List<Role> ugroups;
    @ApiModelProperty(value = "个人角色")
    private List<Role> roles;

    public List<Role> getUgroups() {
        return ugroups;
    }

    public void setUgroups(List<Role> ugroups) {
        this.ugroups = ugroups;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
