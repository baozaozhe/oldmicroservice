package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *   评价指标项值
 *
 */
@ApiModel(value = "评价指标项值")
public class IndicatorVariablesValuesData extends BaseData implements Serializable {
    @ApiModelProperty(value = "指标项")
    private Long itemid;
    @ApiModelProperty(value = "选项编码")
    private String optioncode;
    @ApiModelProperty(value = "选项名称")
    private String optionname;
    @ApiModelProperty(value = "选项量化值")
    private BigDecimal optionvalue;
    @ApiModelProperty(value = "是否是默认选项")
    private String isdefault;

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public String getOptioncode() {
        return optioncode;
    }

    public void setOptioncode(String optioncode) {
        this.optioncode = optioncode;
    }

    public String getOptionname() {
        return optionname;
    }

    public void setOptionname(String optionname) {
        this.optionname = optionname;
    }

    public BigDecimal getOptionvalue() {
        return optionvalue;
    }

    public void setOptionvalue(BigDecimal optionvalue) {
        this.optionvalue = optionvalue;
    }

    public String getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(String isdefault) {
        this.isdefault = isdefault;
    }
}
