package com.qhzk.autogen.freemark.asplusm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   公司-用户表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_company_user
 */
@ApiModel(value = "公司-用户")
public class CompanyUser{
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userid;

    @ApiModelProperty(value = "公司id")
    private Long companyid;

    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    private String operator;

    @ApiModelProperty(value = "最后一次创建时间")
    private Date operatetime;
}
