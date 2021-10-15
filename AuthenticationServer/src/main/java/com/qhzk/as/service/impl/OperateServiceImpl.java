package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Operate;
import com.qhzk.as.mapper.OperateMapper;
import com.qhzk.as.service.OperateService;
import org.springframework.stereotype.Service;

/**
 * 操作信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class OperateServiceImpl extends ServiceImpl<OperateMapper,Operate> implements OperateService {
	@Resource
	private OperateMapper operatemapper;
}
