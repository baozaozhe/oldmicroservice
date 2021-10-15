package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Database Table Remarks:
 *   评价专家表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_pe_task_expert
 */
@ApiModel(value = "评价专家表")
public class TaskExpertData extends BaseData implements Serializable {
    @ApiModelProperty(value = "评价任务")
    private Long taskid;
    @ApiModelProperty(value = "专家ID")
    private Long expertid;
    @ApiModelProperty(value = "专家用户ID")
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

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getExpertid() {
        return expertid;
    }

    public void setExpertid(Long expertid) {
        this.expertid = expertid;
    }

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