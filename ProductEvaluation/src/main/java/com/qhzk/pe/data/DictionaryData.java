package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *   字典表
 */
@ApiModel(value = "字典信息")
public class DictionaryData  extends BaseData implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "字典类型[cd卷烟牌号,pf生产工厂,ob评价对象分类,ao评价对象,nt评价指标项,em评价方法,eml评价模式,eg评价专家组,ig评价指标分组]")
    private String dictype;
    @ApiModelProperty(value = "字典编码")
    private String diccode;
    @ApiModelProperty(value = "字典名称")
    private String dicname;
    @ApiModelProperty(value = "上级字典[faf香糖料 tm原料 fp成品]")
    private String parentcode;

    public String getDictype() {
        return dictype;
    }

    public void setDictype(String dictype) {
        this.dictype = dictype;
    }

    public String getDiccode() {
        return diccode;
    }

    public void setDiccode(String diccode) {
        this.diccode = diccode;
    }

    public String getDicname() {
        return dicname;
    }

    public void setDicname(String dicname) {
        this.dicname = dicname;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }
}
