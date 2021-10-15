package com.qhzk.autogen.freemark.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


/**
 *   专家评价任务
 */
@ApiModel(value = "专家评价任务")
public class TaskExpertTask{
    @ApiModelProperty(value = "评价任务ID")
    private Long taskid;
    @ApiModelProperty(value = "评价任务类型")
    private String tasktype;
    @ApiModelProperty(value = "样品ID")
    private Long specimenid;
    @ApiModelProperty(value = "样品编码")
    private String specode;
    @ApiModelProperty(value = "样品名称")
    private String spename;
    @ApiModelProperty(value = "样品2ID")
    private Long specimen2id;
    @ApiModelProperty(value = "样品2编码")
    private String spe2code;
    @ApiModelProperty(value = "样品2名称")
    private String spe2name;
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
    @ApiModelProperty(value = "任务开始时间")
    private Date starttime;
    @ApiModelProperty(value = "任务结束时间")
    private Date endtime;
    @ApiModelProperty(value = "完成评价时间")
    private Date completiontime;
    @ApiModelProperty(value = "评价方法")
    private String means;
    @ApiModelProperty(value = "评价模式")
    private String evaluationmodel;
    @ApiModelProperty(value = "任务状态（1、待评价；2、保存；3、完成评价；3、超时）")
    private String status;
}
