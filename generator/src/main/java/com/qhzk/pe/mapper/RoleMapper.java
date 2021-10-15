package com.qhzk.pe.mapper;

import com.qhzk.pe.entities.Role;
import com.qhzk.pe.entities.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    long countByExample(RoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int deleteByExample(RoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int insert(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int insertSelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    List<Role> selectByExample(RoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    Role selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Role record);
}