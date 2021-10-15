package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.GenConfig;
import com.qhzk.as.mapper.GenConfigMapper;
import com.qhzk.as.service.GenConfigService;
import org.springframework.stereotype.Service;

/**
 * 代码生成配置 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-29
 */

@Service
public class GenConfigServiceImpl extends ServiceImpl<GenConfigMapper,GenConfig> implements GenConfigService {
	@Resource
	private GenConfigMapper genconfigmapper;
}
