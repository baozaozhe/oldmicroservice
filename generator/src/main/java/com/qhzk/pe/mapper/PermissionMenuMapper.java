package com.qhzk.pe.mapper;

import com.qhzk.pe.entities.PermissionMenu;
import com.qhzk.pe.entities.PermissionMenuCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    long countByExample(PermissionMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int deleteByExample(PermissionMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int insert(PermissionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int insertSelective(PermissionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    List<PermissionMenu> selectByExample(PermissionMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    PermissionMenu selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PermissionMenu record, @Param("example") PermissionMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PermissionMenu record, @Param("example") PermissionMenuCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PermissionMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permissions_menu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PermissionMenu record);
}