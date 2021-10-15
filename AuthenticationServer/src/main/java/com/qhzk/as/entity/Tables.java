package com.qhzk.as.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 表
 * @author: Mr.Muxl
 * @create: 2021-08-26 16:36
 **/
@ApiModel(value = "数据库表")
public class Tables implements Serializable {
    @ApiModelProperty(value = "表名")
    private String tablename;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "存储引擎")
    private String engine;

    @ApiModelProperty(value = "编码")
    private String tablecollation;

    @ApiModelProperty(value = "表描述")
    private String tablecomment;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTablecollation() {
        return tablecollation;
    }

    public void setTablecollation(String tablecollation) {
        this.tablecollation = tablecollation;
    }

    public String getTablecomment() {
        return tablecomment;
    }

    public void setTablecomment(String tablecomment) {
        this.tablecomment = tablecomment;
    }
}
