<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.qhzk.pe.mapper.${objectName}CustomMapper">
    <resultMap id="${objectName}DataMap" type="com.qhzk.pe.data.${objectName}Data"
               extends="com.qhzk.pe.mapper.BaseDataMapper.BaseDataMappingColumn">
        <#list fieldList as var>
        <#if var[3] == 'N'>
        <result column="${var[0]}" jdbcType="${var[2]}" property="${var[0]}"/>
        </#if>
        </#list>
    </resultMap>
    <sql id="MyTableColumn">
    ${columns}
    </sql>
    <select id="count${objectName}PageInfo" parameterType="java.lang.String" resultType="java.lang.Long">
        select count(*) from ${tablename} where pkid is not null
        <#list fieldList as var>
		<if test="value.${var[0]} != null">
            and ${var[0]} like CONCAT('%', ${starttag} value.${var[0]} ,jdbcType=${var[2]} ${endtag} ,'%')
        </if>
        </#list>
        <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataQueryCondition"/>
    </select>
    <select id="query${objectName}PageInfo" parameterType="java.lang.String" resultMap="${objectName}DataMap">
        select
        <include refid="MyTableColumn"/>
        ,
        <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataQueryColumn"/>
        from ${tablename}
        where pkid is not null
        <#list fieldList as var>
		<if test="value.${var[0]} != null">
            and ${var[0]} like CONCAT('%', ${starttag} value.${var[0]} ,jdbcType=${var[2]} ${endtag} ,'%')
        </if>
        </#list>
        <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataQueryCondition"/>
        order by createtime desc
        <if test="page != null">
            <if test="page.start != null and page.pageSize != null">
                limit ${pagelimit!""}
            </if>
        </if>
    </select>

    <select id="selectByPrimaryKey" parameterType="java.lang.Long" resultMap="${objectName}DataMap">
        select
        <include refid="MyTableColumn"/>
        ,
        <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataQueryColumn"/>
        from ${tablename} where pkid =  ${pkid!""} and isdelete ="N"
    </select>

    <update id="deleteLogicByPrimaryKey" parameterType="java.lang.Long">
        UPDATE ${tablename} SET `isdelete` = 'Y' WHERE `pkid` = ${pkid!""}
    </update>

    <update id="batchUpdateValues" parameterType="java.util.List">
        <foreach collection="values" item="value" index="index" separator=";">
            UPDATE ${tablename}
            <set>
             <#list fieldList as var><#if var[3] == 'N'>
              <if test="val.${var[0]} != null">
                  ${var[0]} =${starttag} value.${var[0]} ,jdbcType=${var[2]}${endtag},
              </if>
             </#if></#list>
             <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataBatchModifyColumn"/>
            </set>
            WHERE pkid = ${starttag}value.pkid,jdbcType=BIGINT${endtag}
        </foreach>
    </update>
    <insert id="batchInsertValues" parameterType="java.util.List">
        INSERT INTO ${tablename}(
        <#list fieldList as var><#if var[3] == 'N'>
            ${var[0]},
        </#if></#list>
        <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataInsertColumn"/>
        )
        VALUES
        <foreach collection="values" item="value" index="index" separator=",">
            (
          <#list fieldList as var><#if var[3] == 'N'>
              ${starttag} value.${var[0]} ,jdbcType=${var[2]} ${endtag},
          </#if></#list>
            <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataBatchInsertColumnValue"/>
            )
        </foreach>
    </insert>

    <update id="updateByPrimaryKey" parameterType="com.qhzk.pe.data.${objectName}Data">
        UPDATE ${tablename}
        <set>
           <#list fieldList as var><#if var[3] == 'N'>
              <if test="${var[0]} != null">
                  ${var[0]} =${starttag} ${var[0]} ,jdbcType=${var[2]}${endtag},
              </if>
           </#if></#list>
            <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataModifyColumn"/>
        </set>
        WHERE pkid =  ${pkid!""}
    </update>

    <insert id="insert" parameterType="com.qhzk.pe.data.${objectName}Data" useGeneratedKeys="true" keyProperty="pkid">
        INSERT INTO ${tablename}(
        <#list fieldList as var><#if var[3] == 'N'>
            ${var[0]},
        </#if></#list>
        <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataInsertColumn"/>
        )
        VALUES
        (
         <#list fieldList as var><#if var[3] == 'N'>
             ${starttag} ${var[0]} ,jdbcType=${var[2]} ${endtag},
         </#if></#list>
         <include refid="com.qhzk.pe.mapper.BaseDataMapper.BaseDataInsertColumnValue"/>
        )
    </insert>

    <delete id="deleteRealByPrimaryKey" parameterType="java.lang.Long">
        delete from ${tablename} where pkid =  ${pkid!""}
    </delete>

    <update id="batchLogicDeleteInfo" parameterType="java.lang.String">
        UPDATE ${tablename} SET `isdelete` = 'Y' WHERE `pkid`
        IN (
        <foreach collection="infos" item="infoid" index="index" separator=",">
        ${starttag}infoid,jdbcType=BIGINT${endtag}
        </foreach>
        )
    </update>

    <delete id="batchRealDeleteInfo" parameterType="java.lang.String">
        delete from ${tablename} where pkid
        IN (
        <foreach collection="infos" item="infoid" index="index" separator=",">
        ${starttag} infoid,jdbcType=BIGINT ${endtag}
        </foreach>
        )
    </delete>
</mapper>
