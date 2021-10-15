package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *   评价指标项
 */
@ApiModel(value = "评价指标项")
public class IndicatorVariablesData extends BaseData implements Serializable {
    @ApiModelProperty(value = "指标项编码")
    private String itemcode;
    @ApiModelProperty(value = "指标项名称")
    private String itemname;
    @ApiModelProperty(value = "数据类型[nv 数字,ss 单选,ms 多选,ti 文本输入] ")
    private String datatype;
    @ApiModelProperty(value = "上限")
    private BigDecimal upperlimit;
    @ApiModelProperty(value = "下限")
    private BigDecimal lowerlimit;
    @ApiModelProperty(value = "默认值")
    private String defaultvalues;
    @ApiModelProperty(value = "分值间隔")
    private BigDecimal scoreinterval;
    @ApiModelProperty(value = "评价指标项值列表")
    private List<IndicatorVariablesValuesData> values;

    public List<IndicatorVariablesValuesData> getValues() {
        return values;
    }

    public void setValues(List<IndicatorVariablesValuesData> values) {
        this.values = values;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public BigDecimal getUpperlimit() {
        return upperlimit;
    }

    public void setUpperlimit(BigDecimal upperlimit) {
        this.upperlimit = upperlimit;
    }

    public BigDecimal getLowerlimit() {
        return lowerlimit;
    }

    public void setLowerlimit(BigDecimal lowerlimit) {
        this.lowerlimit = lowerlimit;
    }

    public String getDefaultvalues() {
        return defaultvalues;
    }

    public void setDefaultvalues(String defaultvalues) {
        this.defaultvalues = defaultvalues;
    }

    public BigDecimal getScoreinterval() {
        return scoreinterval;
    }

    public void setScoreinterval(BigDecimal scoreinterval) {
        this.scoreinterval = scoreinterval;
    }
}
