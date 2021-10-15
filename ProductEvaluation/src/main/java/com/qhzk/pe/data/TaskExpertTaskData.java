package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *   专家评价任务
 */
@ApiModel(value = "专家评价任务")
public class TaskExpertTaskData extends BaseData implements Serializable {
    @ApiModelProperty(value = "评价任务ID")
    private Long taskid;
    @ApiModelProperty(value = "评价任务类型")
    private String tasktype;
    @ApiModelProperty(value = "样品ID")
    private Long specimenid;
    @ApiModelProperty(value = "样品编码")
    private String specode;
    @ApiModelProperty(value = "样品名称")
    private String spename;
    @ApiModelProperty(value = "样品2ID")
    private Long specimen2id;
    @ApiModelProperty(value = "样品2编码")
    private String spe2code;
    @ApiModelProperty(value = "样品2名称")
    private String spe2name;
    @ApiModelProperty(value = "专家ID")
    private Long expertid;
    @ApiModelProperty(value = "专家用户ID")
    private Long userid;
    @ApiModelProperty(value = "用户类型")
    private String usertype;
    @ApiModelProperty(value = "账号")
    private String username;
    @ApiModelProperty(value = "姓名")
    private String fullname;
    @ApiModelProperty(value = "电话")
    private String telephone;
    @ApiModelProperty(value = "任务开始时间")
    private Date starttime;
    @ApiModelProperty(value = "任务结束时间")
    private Date endtime;
    @ApiModelProperty(value = "完成评价时间")
    private Date completiontime;
    @ApiModelProperty(value = "评价方法")
    private String means;
    @ApiModelProperty(value = "评价模式")
    private String evaluationmodel;
    @ApiModelProperty(value = "任务状态（1、待评价；2、保存；3、完成评价；3、超时）")
    private String status;

    @ApiModelProperty(value = "评价结果信息")
    private List<TaskExpertTaskResultsData> results;

    public List<TaskExpertTaskResultsData> getResults() {
        return results;
    }

    public void setResults(List<TaskExpertTaskResultsData> results) {
        this.results = results;
    }

    public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }

    public Long getSpecimenid() {
        return specimenid;
    }

    public void setSpecimenid(Long specimenid) {
        this.specimenid = specimenid;
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

    public Long getSpecimen2id() {
        return specimen2id;
    }

    public void setSpecimen2id(Long specimen2id) {
        this.specimen2id = specimen2id;
    }

    public String getSpe2code() {
        return spe2code;
    }

    public void setSpe2code(String spe2code) {
        this.spe2code = spe2code;
    }

    public String getSpe2name() {
        return spe2name;
    }

    public void setSpe2name(String spe2name) {
        this.spe2name = spe2name;
    }

    public Long getExpertid() {
        return expertid;
    }

    public void setExpertid(Long expertid) {
        this.expertid = expertid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getCompletiontime() {
        return completiontime;
    }

    public void setCompletiontime(Date completiontime) {
        this.completiontime = completiontime;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public String getEvaluationmodel() {
        return evaluationmodel;
    }

    public void setEvaluationmodel(String evaluationmodel) {
        this.evaluationmodel = evaluationmodel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
