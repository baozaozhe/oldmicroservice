package com.qhzk.pe.entities;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   部门-用户表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_dept_user
 */
public class DeptUser implements Serializable {
    @ApiModelProperty(value = "部门id")
    private Long id;

    @ApiModelProperty(value = "部门名称")
    private Long userid;

    @ApiModelProperty(value = "上级部门id")
    private Long deptid;

    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    private String operator;

    @ApiModelProperty(value = "最后一次创建时间")
    private Date operatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_as_dept_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.id
     *
     * @return the value of t_as_dept_user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.id
     *
     * @param id the value for t_as_dept_user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.userid
     *
     * @return the value of t_as_dept_user.userid
     *
     * @mbg.generated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.userid
     *
     * @param userid the value for t_as_dept_user.userid
     *
     * @mbg.generated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.deptid
     *
     * @return the value of t_as_dept_user.deptid
     *
     * @mbg.generated
     */
    public Long getDeptid() {
        return deptid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.deptid
     *
     * @param deptid the value for t_as_dept_user.deptid
     *
     * @mbg.generated
     */
    public void setDeptid(Long deptid) {
        this.deptid = deptid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.seq
     *
     * @return the value of t_as_dept_user.seq
     *
     * @mbg.generated
     */
    public String getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.seq
     *
     * @param seq the value for t_as_dept_user.seq
     *
     * @mbg.generated
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.creator
     *
     * @return the value of t_as_dept_user.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.creator
     *
     * @param creator the value for t_as_dept_user.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.createtime
     *
     * @return the value of t_as_dept_user.createtime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.createtime
     *
     * @param createtime the value for t_as_dept_user.createtime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.operator
     *
     * @return the value of t_as_dept_user.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.operator
     *
     * @param operator the value for t_as_dept_user.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_dept_user.operatetime
     *
     * @return the value of t_as_dept_user.operatetime
     *
     * @mbg.generated
     */
    public Date getOperatetime() {
        return operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_dept_user.operatetime
     *
     * @param operatetime the value for t_as_dept_user.operatetime
     *
     * @mbg.generated
     */
    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept_user
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", deptid=").append(deptid);
        sb.append(", seq=").append(seq);
        sb.append(", creator=").append(creator);
        sb.append(", createtime=").append(createtime);
        sb.append(", operator=").append(operator);
        sb.append(", operatetime=").append(operatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}