package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Pelement;
import com.qhzk.as.mapper.PelementMapper;
import com.qhzk.as.service.PelementService;
import org.springframework.stereotype.Service;

/**
 * 页面元素信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class PelementServiceImpl extends ServiceImpl<PelementMapper,Pelement> implements PelementService {
	@Resource
	private PelementMapper pelementmapper;
}
