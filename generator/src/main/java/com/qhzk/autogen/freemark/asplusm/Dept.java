package com.qhzk.autogen.freemark.asplusm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   部门信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_dept
 */
@ApiModel(value = "部门信息表")
public class Dept {
    @ApiModelProperty(value = "部门id")
    private Long id;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "上级部门id")
    private Long parentid;

    @ApiModelProperty(value = "公司id")
    private Long companyid;

    @ApiModelProperty(value = "部门层级")
    private String level;

    private String seq;

    @ApiModelProperty(value = "1:正常 0:冻结2：删除")
    private String status;

    private String remark;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    private String operator;

    @ApiModelProperty(value = "最后一次创建时间")
    private Date operatetime;
}
