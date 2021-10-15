package com.qhzk.autogen.freemark.asplusm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   页面元素信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_pelement
 */
@ApiModel(value = "页面元素信息表")
public class Pelement {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "页面元素编码")
    private String elcode;

    @ApiModelProperty(value = "排序")
    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间 ")
    private Date createtime;

    @ApiModelProperty(value = "最后一次操作者")
    private String operator;

    @ApiModelProperty(value = " 最后一次 操作时间 ")
    private Date operatetime;
}
