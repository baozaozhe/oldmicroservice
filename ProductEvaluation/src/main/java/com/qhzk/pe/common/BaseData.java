package com.qhzk.pe.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 基础数据对象
 * @author: Mr.Muxl
 * @create: 2021-06-28 13:23
 **/
@ApiModel(value = "基础数据对象")
public class BaseData  implements Serializable {
    @ApiModelProperty(value = "公用字段-id")
    private Long  pkid;
    @ApiModelProperty(value = "公用字段-拥有角色")
    private Long  owner;
    @ApiModelProperty(value = "公用字段-拥有者用户组")
    private Long  ownergroup;
    @ApiModelProperty(value = "公用字段-拥有者用户类型")
    private String  ownertype;
    @ApiModelProperty(value = "公用字段-创建人")
    private Long  creator;
    @ApiModelProperty(value = "公用字段-创建人用户组")
    private Long  creatorgroup;
    @ApiModelProperty(value = "公用字段-创建人用户类型")
    private String  creatortype;
    @ApiModelProperty(value = "公用字段-创建时间")
    private Date  createtime;
    @ApiModelProperty(value = "公用字段-最后编辑人")
    private Long  lastmodify;
    @ApiModelProperty(value = "公用字段-最后编辑人用户组")
    private Long  lastmodifygroup;
    @ApiModelProperty(value = "公用字段-最后编辑人用户类型")
    private String  lastmodifytype ;
    @ApiModelProperty(value = "公用字段-最后编辑时间")
    private Date  lastmodifiedtime;
    @ApiModelProperty(value = "公用字段-删除人")
    private Long  deleter;
    @ApiModelProperty(value = "公用字段-删除人用户组")
    private Long  deletegroup;
    @ApiModelProperty(value = "公用字段-删除人用户类型")
    private String  deletetype;
    @ApiModelProperty(value = "公用字段-删除时间")
    private Date deletetime;
    @ApiModelProperty(value = "公用字段-删除标示（Y：删除、N：正常）")
    private String  isdelete;
    @ApiModelProperty(value = "公用字段-备注")
    private String  description;

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Long getOwnergroup() {
        return ownergroup;
    }

    public void setOwnergroup(Long ownergroup) {
        this.ownergroup = ownergroup;
    }

    public String getOwnertype() {
        return ownertype;
    }

    public void setOwnertype(String ownertype) {
        this.ownertype = ownertype;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getCreatorgroup() {
        return creatorgroup;
    }

    public void setCreatorgroup(Long creatorgroup) {
        this.creatorgroup = creatorgroup;
    }

    public String getCreatortype() {
        return creatortype;
    }

    public void setCreatortype(String creatortype) {
        this.creatortype = creatortype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getLastmodify() {
        return lastmodify;
    }

    public void setLastmodify(Long lastmodify) {
        this.lastmodify = lastmodify;
    }

    public Long getLastmodifygroup() {
        return lastmodifygroup;
    }

    public void setLastmodifygroup(Long lastmodifygroup) {
        this.lastmodifygroup = lastmodifygroup;
    }

    public String getLastmodifytype() {
        return lastmodifytype;
    }

    public void setLastmodifytype(String lastmodifytype) {
        this.lastmodifytype = lastmodifytype;
    }

    public Date getLastmodifiedtime() {
        return lastmodifiedtime;
    }

    public void setLastmodifiedtime(Date lastmodifiedtime) {
        this.lastmodifiedtime = lastmodifiedtime;
    }

    public Long getDeleter() {
        return deleter;
    }

    public void setDeleter(Long deleter) {
        this.deleter = deleter;
    }

    public Long getDeletegroup() {
        return deletegroup;
    }

    public void setDeletegroup(Long deletegroup) {
        this.deletegroup = deletegroup;
    }

    public String getDeletetype() {
        return deletetype;
    }

    public void setDeletetype(String deletetype) {
        this.deletetype = deletetype;
    }

    public Date getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
