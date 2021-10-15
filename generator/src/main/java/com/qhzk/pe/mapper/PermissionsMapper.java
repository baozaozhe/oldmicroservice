package com.qhzk.pe.mapper;

import com.qhzk.pe.entities.Permissions;
import com.qhzk.pe.entities.PermissionsCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    long countByExample(PermissionsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int deleteByExample(PermissionsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int insert(Permissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int insertSelective(Permissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    List<Permissions> selectByExample(PermissionsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    Permissions selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Permissions record, @Param("example") PermissionsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Permissions record, @Param("example") PermissionsCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Permissions record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Permissions record);
}