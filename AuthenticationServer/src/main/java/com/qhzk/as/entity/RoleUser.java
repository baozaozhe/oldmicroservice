package com.qhzk.as.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   用户-角色关联信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_role_user
 */
@ApiModel(value = "用户-角色关联信息表")
@TableName("t_as_role_user")
public class RoleUser implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userid;

    @ApiModelProperty(value = "角色id")
    private Long roleid;

    @ApiModelProperty(value = "排序")
    private String seq;

    @ApiModelProperty(value = "创建人")
    private String creator;

    @ApiModelProperty(value = "创建时间 ")
    private Date createtime;

    @ApiModelProperty(value = "最后一次操作者")
    private String operator;

    @ApiModelProperty(value = " 最后一次 操作时间 ")
    private Date operatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_as_role_user
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.id
     *
     * @return the value of t_as_role_user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.id
     *
     * @param id the value for t_as_role_user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.userid
     *
     * @return the value of t_as_role_user.userid
     *
     * @mbg.generated
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.userid
     *
     * @param userid the value for t_as_role_user.userid
     *
     * @mbg.generated
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.roleid
     *
     * @return the value of t_as_role_user.roleid
     *
     * @mbg.generated
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.roleid
     *
     * @param roleid the value for t_as_role_user.roleid
     *
     * @mbg.generated
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.seq
     *
     * @return the value of t_as_role_user.seq
     *
     * @mbg.generated
     */
    public String getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.seq
     *
     * @param seq the value for t_as_role_user.seq
     *
     * @mbg.generated
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.creator
     *
     * @return the value of t_as_role_user.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.creator
     *
     * @param creator the value for t_as_role_user.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.createtime
     *
     * @return the value of t_as_role_user.createtime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.createtime
     *
     * @param createtime the value for t_as_role_user.createtime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.operator
     *
     * @return the value of t_as_role_user.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.operator
     *
     * @param operator the value for t_as_role_user.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_role_user.operatetime
     *
     * @return the value of t_as_role_user.operatetime
     *
     * @mbg.generated
     */
    public Date getOperatetime() {
        return operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_role_user.operatetime
     *
     * @param operatetime the value for t_as_role_user.operatetime
     *
     * @mbg.generated
     */
    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role_user
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
        sb.append(", roleid=").append(roleid);
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
