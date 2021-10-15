package com.qhzk.as.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   权限-菜单信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_permissions_menu
 */
@ApiModel(value = "权限-菜单信息表")
@TableName("t_as_permissions_menu")
public class PermissionMenu implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "权限id")
    private Long permissid;

    @ApiModelProperty(value = "菜单id")
    private Long menuid;

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
     * This field corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.id
     *
     * @return the value of t_as_permissions_menu.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.id
     *
     * @param id the value for t_as_permissions_menu.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.permissid
     *
     * @return the value of t_as_permissions_menu.permissid
     *
     * @mbg.generated
     */
    public Long getPermissid() {
        return permissid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.permissid
     *
     * @param permissid the value for t_as_permissions_menu.permissid
     *
     * @mbg.generated
     */
    public void setPermissid(Long permissid) {
        this.permissid = permissid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.menuid
     *
     * @return the value of t_as_permissions_menu.menuid
     *
     * @mbg.generated
     */
    public Long getMenuid() {
        return menuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.menuid
     *
     * @param menuid the value for t_as_permissions_menu.menuid
     *
     * @mbg.generated
     */
    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.seq
     *
     * @return the value of t_as_permissions_menu.seq
     *
     * @mbg.generated
     */
    public String getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.seq
     *
     * @param seq the value for t_as_permissions_menu.seq
     *
     * @mbg.generated
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.creator
     *
     * @return the value of t_as_permissions_menu.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.creator
     *
     * @param creator the value for t_as_permissions_menu.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.createtime
     *
     * @return the value of t_as_permissions_menu.createtime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.createtime
     *
     * @param createtime the value for t_as_permissions_menu.createtime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.operator
     *
     * @return the value of t_as_permissions_menu.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.operator
     *
     * @param operator the value for t_as_permissions_menu.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permissions_menu.operatetime
     *
     * @return the value of t_as_permissions_menu.operatetime
     *
     * @mbg.generated
     */
    public Date getOperatetime() {
        return operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permissions_menu.operatetime
     *
     * @param operatetime the value for t_as_permissions_menu.operatetime
     *
     * @mbg.generated
     */
    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
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
        sb.append(", permissid=").append(permissid);
        sb.append(", menuid=").append(menuid);
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
