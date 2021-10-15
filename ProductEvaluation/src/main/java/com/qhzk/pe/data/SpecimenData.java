package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 *   样品表
 */
@ApiModel(value = "样品表")
public class SpecimenData extends BaseData implements Serializable {
    @ApiModelProperty(value = "样品类型 fs香精香料样品 ma原料样品")
    private String spetype;
    @ApiModelProperty(value = "样品编码")
    private String specode;
    @ApiModelProperty(value = "样品名称")
    private String spename;
    @ApiModelProperty(value = "样品添加人")
    private String speadder;
    @ApiModelProperty(value = "样品扩展属性信息")
    private List<SpecimenAttrsData> attrsdatas;

    public List<SpecimenAttrsData> getAttrsdatas() {
        return attrsdatas;
    }

    public void setAttrsdatas(List<SpecimenAttrsData> attrsdatas) {
        this.attrsdatas = attrsdatas;
    }

    public String getSpetype() {
        return spetype;
    }

    public void setSpetype(String spetype) {
        this.spetype = spetype;
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

    public String getSpeadder() {
        return speadder;
    }

    public void setSpeadder(String speadder) {
        this.speadder = speadder;
    }
}
