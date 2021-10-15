package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.PermissPelement;
import com.qhzk.as.mapper.PermissPelementMapper;
import com.qhzk.as.service.PermissPelementService;
import org.springframework.stereotype.Service;

/**
 * 权限-页面元素信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class PermissPelementServiceImpl extends ServiceImpl<PermissPelementMapper,PermissPelement> implements PermissPelementService {
	@Resource
	private PermissPelementMapper permisspelementmapper;
}
