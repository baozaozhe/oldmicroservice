package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.PermissOperate;
import com.qhzk.as.mapper.PermissOperateMapper;
import com.qhzk.as.service.PermissOperateService;
import org.springframework.stereotype.Service;

/**
 * 权限的操作信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-09
 */

@Service
public class PermissOperateServiceImpl extends ServiceImpl<PermissOperateMapper,PermissOperate> implements PermissOperateService {
	@Resource
	private PermissOperateMapper permissoperatemapper;
}
