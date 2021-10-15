package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   评价标准适用范围
 */
@ApiModel(value = "评价标准适用范围")
public class EvaluationStandardScopeData extends BaseData implements Serializable {
    @ApiModelProperty(value = "标准")
    private Long standardid;
    @ApiModelProperty(value = "标准适用编码")
    private String scopecode;
    @ApiModelProperty(value = "标准适用")
    private String scopename;

    public Long getStandardid() {
        return standardid;
    }

    public void setStandardid(Long standardid) {
        this.standardid = standardid;
    }

    public String getScopecode() {
        return scopecode;
    }

    public void setScopecode(String scopecode) {
        this.scopecode = scopecode;
    }

    public String getScopename() {
        return scopename;
    }

    public void setScopename(String scopename) {
        this.scopename = scopename;
    }
}
