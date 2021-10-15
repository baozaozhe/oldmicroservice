package com.qhzk.autogen.freemark.asplusm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   权限信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_permissions
 */
@ApiModel(value = "权限信息表")
public class Permissions  {
    @ApiModelProperty(value = "权限id")
    private Long id;

    @ApiModelProperty(value = "权限代码")
    private String code;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "1:菜单 2:页面元素 3:文件 4:功能操作")
    private String type;

    @ApiModelProperty(value = "1:正常 0:冻结2：删除")
    private String status;

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
