package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *   评价标准
 */
@ApiModel(value = "评价标准")
public class EvaluationStandardData extends BaseData implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "标准编码")
    private String standardcode;
    @ApiModelProperty(value = "标准名称")
    private String standardname;
    @ApiModelProperty(value = "标准类型")
    private String standardtype;
    @ApiModelProperty(value = "制定日期")
    private Date createdate;
    @ApiModelProperty(value = "标准版本")
    private BigDecimal standardversion;
    @ApiModelProperty(value = "状态")
    private String status;
    @ApiModelProperty(value = "评价标准明细信息")
    private List<EvaluationStandardItemData> items;
    @ApiModelProperty(value = "评价标准适用范围信息")
    private List<EvaluationStandardScopeData> scopes;
    @ApiModelProperty(value = "评价标准适用评价方法")
    private EvaluationStandardMethodologyData method;

    public List<EvaluationStandardItemData> getItems() {
        return items;
    }

    public void setItems(List<EvaluationStandardItemData> items) {
        this.items = items;
    }

    public List<EvaluationStandardScopeData> getScopes() {
        return scopes;
    }

    public void setScopes(List<EvaluationStandardScopeData> scopes) {
        this.scopes = scopes;
    }

    public EvaluationStandardMethodologyData getMethod() {
        return method;
    }

    public void setMethod(EvaluationStandardMethodologyData method) {
        this.method = method;
    }

    public String getStandardcode() {
        return standardcode;
    }

    public void setStandardcode(String standardcode) {
        this.standardcode = standardcode;
    }

    public String getStandardname() {
        return standardname;
    }

    public void setStandardname(String standardname) {
        this.standardname = standardname;
    }

    public String getStandardtype() {
        return standardtype;
    }

    public void setStandardtype(String standardtype) {
        this.standardtype = standardtype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public BigDecimal getStandardversion() {
        return standardversion;
    }

    public void setStandardversion(BigDecimal standardversion) {
        this.standardversion = standardversion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
