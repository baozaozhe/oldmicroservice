package com.qhzk.autogen.freemark.modle;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 *   评价任务样品
 */
@ApiModel(value = "评价任务样品")
public class TaskSpecimen{
    @ApiModelProperty(value = "评价任务")
    private Long taskid;
    @ApiModelProperty(value = "样品ID")
    private Long specimenid;
    @ApiModelProperty(value = "样品编码")
    private String specode;
    @ApiModelProperty(value = "样品名称")
    private String spename;
}
