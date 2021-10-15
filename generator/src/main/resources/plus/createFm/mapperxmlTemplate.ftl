<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.qhzk.as.mapper.${objectName}Mapper">
    <resultMap id="${objectName}Map" type="com.qhzk.as.entity.${objectName}">
        <result column="id" jdbcType="BIGINT" property="id"/>
        <#list fieldList as var>
        <#if var[3] == 'N'>
        <result column="${var[0]}" jdbcType="${var[2]}" property="${var[0]}"/>
        </#if>
        </#list>
    </resultMap>
    <sql id="${objectName}Column">
        ${columns}
    </sql>
</mapper>
