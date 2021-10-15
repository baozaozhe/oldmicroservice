package com.qhzk.pe.data;

import com.qhzk.pe.common.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *   评价任务
 */
@ApiModel(value = "评价任务")
public class TaskData extends BaseData implements Serializable {
    @ApiModelProperty(value = "评价任务编号")
    private String taskcode;
    @ApiModelProperty(value = "评价任务名称")
    private String taskname;
    @ApiModelProperty(value = "评价任务类型 fs香精香料评价任务 ma原料评价任务")
    private String tasktype;
    @ApiModelProperty(value = "任务开始时间")
    private Date starttime;
    @ApiModelProperty(value = "任务结束时间")
    private Date endtime;
    @ApiModelProperty(value = "任务发布时间")
    private Date releasetime;
    @ApiModelProperty(value = "任务发布人")
    private String taskissuer;
    @ApiModelProperty(value = "评价对象")
    private String scope;
    @ApiModelProperty(value = "评价方法")
    private String means;
    @ApiModelProperty(value = "评价地点")
    private String location;
    @ApiModelProperty(value = "评价模式")
    private String evaluationmodel;
    @ApiModelProperty(value = "任务状态（1、保存；2、发布；3、停止）")
    private String status;
    @ApiModelProperty(value = "评价专家")
    private List<TaskExpertData> experts;
    @ApiModelProperty(value = "样品信息")
    private List<TaskSpecimenData> specimens;
    @ApiModelProperty(value = "使用标准信息")
    private List<TaskStandardData> standards;

    public List<TaskExpertData> getExperts() {
        return experts;
    }

    public void setExperts(List<TaskExpertData> experts) {
        this.experts = experts;
    }

    public List<TaskSpecimenData> getSpecimens() {
        return specimens;
    }

    public void setSpecimens(List<TaskSpecimenData> specimens) {
        this.specimens = specimens;
    }

    public List<TaskStandardData> getStandards() {
        return standards;
    }

    public void setStandards(List<TaskStandardData> standards) {
        this.standards = standards;
    }

    public String getTaskcode() {
        return taskcode;
    }

    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
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

    public Date getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getTaskissuer() {
        return taskissuer;
    }

    public void setTaskissuer(String taskissuer) {
        this.taskissuer = taskissuer;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
