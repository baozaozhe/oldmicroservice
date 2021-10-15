package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.${objectName};
import com.qhzk.as.mapper.${objectName}Mapper;
import com.qhzk.as.service.${objectName}Service;
import org.springframework.stereotype.Service;

/**
 * ${title} Service实现类
 * @author: Mr.Muxl
 * @date ${nowDate?string("yyyy-MM-dd")}
 */

@Service
public class ${objectName}ServiceImpl extends ServiceImpl<${objectName}Mapper,${objectName}> implements ${objectName}Service {
	@Resource
	private ${objectName}Mapper ${objectNameLower}mapper;
}
