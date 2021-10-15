package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   扩展属性表
 */
@ApiModel(value = "扩展属性参数")
public class AttributesData  extends BaseData implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "属性分类 [fs香精香料样品管理]")
    private String attrtype;
    @ApiModelProperty(value = "属性分类名称")
    private String attrtypename;
    @ApiModelProperty(value = "属性编码")
    private String attrcode;
    @ApiModelProperty(value = "属性名称")
    private String attrname;
    @ApiModelProperty(value = "属性值")
    private String attrvalue;
    @ApiModelProperty(value = "属性描述")
    private String attrdesc;
    @ApiModelProperty(value = "属性数据类型")
    private String datatype;
    @ApiModelProperty(value = "是否允许为空")
    private Integer allowblank;
    @ApiModelProperty(value = "显示顺序")
    private Integer sequencing;
    @ApiModelProperty(value = "显示控件")
    private Integer indicator;
    @ApiModelProperty(value = "显示控件label对接方式")
    private String labelalign;
    @ApiModelProperty(value = "显示控件label宽度")
    private Integer labelwidth;
    @ApiModelProperty(value = "显示控件宽度")
    private Integer indicatorwidth;
    @ApiModelProperty(value = "显示控件高度")
    private Integer indicatorheight;
    @ApiModelProperty(value = "是否在列表显示")
    private Integer islist;
    @ApiModelProperty(value = "独行显示")
    private Integer independentline;

    public String getAttrtype() {
        return attrtype;
    }

    public void setAttrtype(String attrtype) {
        this.attrtype = attrtype;
    }

    public String getAttrtypename() {
        return attrtypename;
    }

    public void setAttrtypename(String attrtypename) {
        this.attrtypename = attrtypename;
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

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Integer getAllowblank() {
        return allowblank;
    }

    public void setAllowblank(Integer allowblank) {
        this.allowblank = allowblank;
    }

    public Integer getSequencing() {
        return sequencing;
    }

    public void setSequencing(Integer sequencing) {
        this.sequencing = sequencing;
    }

    public Integer getIndicator() {
        return indicator;
    }

    public void setIndicator(Integer indicator) {
        this.indicator = indicator;
    }

    public String getLabelalign() {
        return labelalign;
    }

    public void setLabelalign(String labelalign) {
        this.labelalign = labelalign;
    }

    public Integer getLabelwidth() {
        return labelwidth;
    }

    public void setLabelwidth(Integer labelwidth) {
        this.labelwidth = labelwidth;
    }

    public Integer getIndicatorwidth() {
        return indicatorwidth;
    }

    public void setIndicatorwidth(Integer indicatorwidth) {
        this.indicatorwidth = indicatorwidth;
    }

    public Integer getIndicatorheight() {
        return indicatorheight;
    }

    public void setIndicatorheight(Integer indicatorheight) {
        this.indicatorheight = indicatorheight;
    }

    public Integer getIslist() {
        return islist;
    }

    public void setIslist(Integer islist) {
        this.islist = islist;
    }

    public Integer getIndependentline() {
        return independentline;
    }

    public void setIndependentline(Integer independentline) {
        this.independentline = independentline;
    }
}
