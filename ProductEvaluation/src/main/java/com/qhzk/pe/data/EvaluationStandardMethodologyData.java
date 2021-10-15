package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   评价标准适用评价方法
 */
@ApiModel(value = "评价标准适用评价方法")
public class EvaluationStandardMethodologyData extends BaseData implements Serializable {
    @ApiModelProperty(value = "标准")
    private Long standardid;
    @ApiModelProperty(value = "标准适用评价方法编码")
    private String methodologycode;
    @ApiModelProperty(value = "标准适用评价方法")
    private String methodologyname;

    public Long getStandardid() {
        return standardid;
    }

    public void setStandardid(Long standardid) {
        this.standardid = standardid;
    }

    public String getMethodologycode() {
        return methodologycode;
    }

    public void setMethodologycode(String methodologycode) {
        this.methodologycode = methodologycode;
    }

    public String getMethodologyname() {
        return methodologyname;
    }

    public void setMethodologyname(String methodologyname) {
        this.methodologyname = methodologyname;
    }
}
