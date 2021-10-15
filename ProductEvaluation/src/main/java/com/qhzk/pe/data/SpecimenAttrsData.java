package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   样品扩展属性表
 */
@ApiModel(value = " 样品扩展属性表")
public class SpecimenAttrsData extends BaseData implements Serializable {
    @ApiModelProperty(value = "样品ID")
    private Long speid;
    @ApiModelProperty(value = "属性编码")
    private String attrcode;
    @ApiModelProperty(value = "属性名称")
    private String attrname;
    @ApiModelProperty(value = "属性值")
    private String attrvalue;
    @ApiModelProperty(value = "属性描述")
    private String attrdesc;

    public Long getSpeid() {
        return speid;
    }

    public void setSpeid(Long speid) {
        this.speid = speid;
    }

    public String getAttrcode() {
        return attrcode;
    }

    public void setAttrcode(String attrcode) {
        this.attrcode = attrcode;
    }

    public String getAttrname() {
        return attrname;
    }

    public void setAttrname(String attrname) {
        this.attrname = attrname;
    }

    public String getAttrvalue() {
        return attrvalue;
    }

    public void setAttrvalue(String attrvalue) {
        this.attrvalue = attrvalue;
    }

    public String getAttrdesc() {
        return attrdesc;
    }

    public void setAttrdesc(String attrdesc) {
        this.attrdesc = attrdesc;
    }
}
