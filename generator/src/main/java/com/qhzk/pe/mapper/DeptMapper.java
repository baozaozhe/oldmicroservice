package com.qhzk.pe.mapper;

import com.qhzk.pe.entities.Dept;
import com.qhzk.pe.entities.DeptCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    long countByExample(DeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int deleteByExample(DeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int insert(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int insertSelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    List<Dept> selectByExample(DeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    Dept selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Dept record, @Param("example") DeptCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Dept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_dept
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Dept record);
}