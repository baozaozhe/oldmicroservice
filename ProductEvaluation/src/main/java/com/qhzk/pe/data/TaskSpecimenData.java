package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   评价任务样品
 */
@ApiModel(value = "评价任务样品")
public class TaskSpecimenData extends BaseData implements Serializable {
    @ApiModelProperty(value = "评价任务")
    private Long taskid;
    @ApiModelProperty(value = "样品ID")
    private Long specimenid;
    @ApiModelProperty(value = "样品编码")
    private String specode;
    @ApiModelProperty(value = "样品名称")
    private String spename;

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getSpecimenid() {
        return specimenid;
    }

    public void setSpecimenid(Long specimenid) {
        this.specimenid = specimenid;
    }

    public String getSpecode() {
        return specode;
    }

    public void setSpecode(String specode) {
        this.specode = specode;
    }

    public String getSpename() {
        return spename;
    }

    public void setSpename(String spename) {
        this.spename = spename;
    }
}
