package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *   评价标准明细
 */
@ApiModel(value = "评价标准明细")
public class EvaluationStandardItemData extends BaseData implements Serializable {
    @ApiModelProperty(value = "评价标准")
    private Long standardid;
    @ApiModelProperty(value = "上级指标")
    private String parentid;
    @ApiModelProperty(value = "指标项")
    private Long itemid;
    @ApiModelProperty(value = "分组ID")
    private Long groupid;
    @ApiModelProperty(value = "类型(1、指标；2、分组)")
    private String type;
    @ApiModelProperty(value = "指标项编码")
    private String itemcode;
    @ApiModelProperty(value = "指标项名称")
    private String itemname;
    @ApiModelProperty(value = "数据类型")
    private String datatype;
    @ApiModelProperty(value = "上限")
    private BigDecimal upperlimit;
    @ApiModelProperty(value = "下限")
    private BigDecimal lowerlimit;
    @ApiModelProperty(value = "默认值")
    private String defaultvalues;
    @ApiModelProperty(value = "分值间隔")
    private BigDecimal scoreinterval;
    @ApiModelProperty(value = "显示顺序")
    private Integer sequencing;

    @ApiModelProperty(value = "子集")
    private List<EvaluationStandardItemData> childs;

    public List<EvaluationStandardItemData> getChilds() {
        return childs;
    }

    public void setChilds(List<EvaluationStandardItemData> childs) {
        this.childs = childs;
    }

    public Long getStandardid() {
        return standardid;
    }

    public void setStandardid(Long standardid) {
        this.standardid = standardid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public Long getGroupid() {
        return groupid;
    }

    public void setGroupid(Long groupid) {
        this.groupid = groupid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getSequencing() {
        return sequencing;
    }

    public void setSequencing(Integer sequencing) {
        this.sequencing = sequencing;
    }
}
