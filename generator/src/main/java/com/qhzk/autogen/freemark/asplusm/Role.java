package com.qhzk.autogen.freemark.asplusm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   角色信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_role
 */
@ApiModel(value = "角色信息表")
public class Role  {
    @ApiModelProperty(value = "角色id")
    private Long id;

    @ApiModelProperty(value = "部门名称")
    private String name;

    @ApiModelProperty(value = "1:正常 0:冻结2：删除")
    private String status;

    @ApiModelProperty(value = "描述")
    private String remark;

    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    private String operator;

    @ApiModelProperty(value = "最后一次创建时间")
    private Date operatetime;

}
