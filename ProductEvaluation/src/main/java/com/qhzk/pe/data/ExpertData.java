package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   专家表
 */
@ApiModel(value = "专家信息")
public class ExpertData extends BaseData implements Serializable {
    @ApiModelProperty(value = "用户id")
    private Long userid;
    @ApiModelProperty(value = "用户类型")
    private String usertype;
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "姓名")
    private String fullname;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "专家组")
    private String expertgroup;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getExpertgroup() {
        return expertgroup;
    }

    public void setExpertgroup(String expertgroup) {
        this.expertgroup = expertgroup;
    }
}
