package com.qhzk.autogen.freemark.asplusm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   操作信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_operate
 */
@ApiModel(value = "操作信息表")
public class Operate {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "操作编码")
    private String opercode;

    @ApiModelProperty(value = "拦截url")
    private String intercepturl;

    @ApiModelProperty(value = "父级操作id")
    private Long parentid;

    @ApiModelProperty(value = "排序")
    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "最后一次操作者")
    private String operator;

    @ApiModelProperty(value = " 最后一次 操作时间")
    private Date operatetime;

}
