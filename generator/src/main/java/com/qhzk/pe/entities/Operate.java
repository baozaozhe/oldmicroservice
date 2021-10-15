package com.qhzk.pe.entities;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   操作信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_operate
 */
public class Operate implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "操作编码")
    private String opercode;

    @ApiModelProperty(value = "拦截url")
    private String intercepturl;

    @ApiModelProperty(value = "父级操作id")
    private Long parentid;

    @ApiModelProperty(value = "排序")
    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Date createtime;

    @ApiModelProperty(value = "最后一次操作者")
    private String operator;

    @ApiModelProperty(value = " 最后一次 操作时间")
    private Date operatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.id
     *
     * @return the value of t_as_operate.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.id
     *
     * @param id the value for t_as_operate.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.name
     *
     * @return the value of t_as_operate.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.name
     *
     * @param name the value for t_as_operate.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.opercode
     *
     * @return the value of t_as_operate.opercode
     *
     * @mbg.generated
     */
    public String getOpercode() {
        return opercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.opercode
     *
     * @param opercode the value for t_as_operate.opercode
     *
     * @mbg.generated
     */
    public void setOpercode(String opercode) {
        this.opercode = opercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.intercepturl
     *
     * @return the value of t_as_operate.intercepturl
     *
     * @mbg.generated
     */
    public String getIntercepturl() {
        return intercepturl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.intercepturl
     *
     * @param intercepturl the value for t_as_operate.intercepturl
     *
     * @mbg.generated
     */
    public void setIntercepturl(String intercepturl) {
        this.intercepturl = intercepturl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.parentid
     *
     * @return the value of t_as_operate.parentid
     *
     * @mbg.generated
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.parentid
     *
     * @param parentid the value for t_as_operate.parentid
     *
     * @mbg.generated
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.seq
     *
     * @return the value of t_as_operate.seq
     *
     * @mbg.generated
     */
    public String getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.seq
     *
     * @param seq the value for t_as_operate.seq
     *
     * @mbg.generated
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.creator
     *
     * @return the value of t_as_operate.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.creator
     *
     * @param creator the value for t_as_operate.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.createtime
     *
     * @return the value of t_as_operate.createtime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.createtime
     *
     * @param createtime the value for t_as_operate.createtime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.operator
     *
     * @return the value of t_as_operate.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.operator
     *
     * @param operator the value for t_as_operate.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_operate.operatetime
     *
     * @return the value of t_as_operate.operatetime
     *
     * @mbg.generated
     */
    public Date getOperatetime() {
        return operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_operate.operatetime
     *
     * @param operatetime the value for t_as_operate.operatetime
     *
     * @mbg.generated
     */
    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
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
        sb.append(", name=").append(name);
        sb.append(", opercode=").append(opercode);
        sb.append(", intercepturl=").append(intercepturl);
        sb.append(", parentid=").append(parentid);
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