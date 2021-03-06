package com.qhzk.pe.mapper;

import com.qhzk.pe.entities.Operate;
import com.qhzk.pe.entities.OperateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    long countByExample(OperateCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int deleteByExample(OperateCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int insert(Operate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int insertSelective(Operate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    List<Operate> selectByExample(OperateCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    Operate selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Operate record, @Param("example") OperateCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Operate record, @Param("example") OperateCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Operate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_operate
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Operate record);
}