package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *   评价任务使用标准
 */
@ApiModel(value = "评价任务使用标准")
public class TaskStandardData extends BaseData implements Serializable {
    @ApiModelProperty(value = "评价任务")
    private Long taskid;
    @ApiModelProperty(value = "评价标准ID")
    private Long standardid;
    @ApiModelProperty(value = "标准名称")
    private String standardname;
    @ApiModelProperty(value = "标准版本")
    private BigDecimal standardversion;

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getStandardid() {
        return standardid;
    }

    public void setStandardid(Long standardid) {
        this.standardid = standardid;
    }

    public String getStandardname() {
        return standardname;
    }

    public void setStandardname(String standardname) {
        this.standardname = standardname;
    }

    public BigDecimal getStandardversion() {
        return standardversion;
    }

    public void setStandardversion(BigDecimal standardversion) {
        this.standardversion = standardversion;
    }
}
