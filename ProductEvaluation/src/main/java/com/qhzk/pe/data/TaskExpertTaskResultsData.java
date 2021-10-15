package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *   专家评价结果表
 */
@ApiModel(value = "专家评价结果")
public class TaskExpertTaskResultsData extends BaseData implements Serializable {
    @ApiModelProperty(value = "专家评价任务ID")
    private Long tetaskid;
    @ApiModelProperty(value = "评价标准")
    private Long standardid;
    @ApiModelProperty(value = "标准编码")
    private String standardcode;
    @ApiModelProperty(value = "标准名称")
    private String standardname;
    @ApiModelProperty(value = "指标项编码")
    private String itemcode;
    @ApiModelProperty(value = "指标项名称")
    private String itemname;
    @ApiModelProperty(value = "指标项值")
    private String itemvalue;
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

    public Long getTetaskid() {
        return tetaskid;
    }

    public void setTetaskid(Long tetaskid) {
        this.tetaskid = tetaskid;
    }

    public Long getStandardid() {
        return standardid;
    }

    public void setStandardid(Long standardid) {
        this.standardid = standardid;
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

    public String getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue;
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
