package com.qhzk.as.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   权限-文件信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table t_as_permiss_file
 */
@ApiModel(value = "权限-文件信息表")
@TableName("t_as_permiss_file")
public class PermissFile implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "权限id")
    private Long permissid;

    @ApiModelProperty(value = "文件id")
    private Long fileid;

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
     * This field corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.id
     *
     * @return the value of t_as_permiss_file.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.id
     *
     * @param id the value for t_as_permiss_file.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.permissid
     *
     * @return the value of t_as_permiss_file.permissid
     *
     * @mbg.generated
     */
    public Long getPermissid() {
        return permissid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.permissid
     *
     * @param permissid the value for t_as_permiss_file.permissid
     *
     * @mbg.generated
     */
    public void setPermissid(Long permissid) {
        this.permissid = permissid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.fileid
     *
     * @return the value of t_as_permiss_file.fileid
     *
     * @mbg.generated
     */
    public Long getFileid() {
        return fileid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.fileid
     *
     * @param fileid the value for t_as_permiss_file.fileid
     *
     * @mbg.generated
     */
    public void setFileid(Long fileid) {
        this.fileid = fileid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.seq
     *
     * @return the value of t_as_permiss_file.seq
     *
     * @mbg.generated
     */
    public String getSeq() {
        return seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.seq
     *
     * @param seq the value for t_as_permiss_file.seq
     *
     * @mbg.generated
     */
    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.creator
     *
     * @return the value of t_as_permiss_file.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.creator
     *
     * @param creator the value for t_as_permiss_file.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.createtime
     *
     * @return the value of t_as_permiss_file.createtime
     *
     * @mbg.generated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.createtime
     *
     * @param createtime the value for t_as_permiss_file.createtime
     *
     * @mbg.generated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.operator
     *
     * @return the value of t_as_permiss_file.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.operator
     *
     * @param operator the value for t_as_permiss_file.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_as_permiss_file.operatetime
     *
     * @return the value of t_as_permiss_file.operatetime
     *
     * @mbg.generated
     */
    public Date getOperatetime() {
        return operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_as_permiss_file.operatetime
     *
     * @param operatetime the value for t_as_permiss_file.operatetime
     *
     * @mbg.generated
     */
    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
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
        sb.append(", fileid=").append(fileid);
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
