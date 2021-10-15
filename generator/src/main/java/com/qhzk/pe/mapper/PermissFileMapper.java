package com.qhzk.pe.mapper;

import com.qhzk.pe.entities.PermissFile;
import com.qhzk.pe.entities.PermissFileCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    long countByExample(PermissFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int deleteByExample(PermissFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int insert(PermissFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int insertSelective(PermissFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    List<PermissFile> selectByExample(PermissFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    PermissFile selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PermissFile record, @Param("example") PermissFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PermissFile record, @Param("example") PermissFileCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(PermissFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_as_permiss_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(PermissFile record);
}