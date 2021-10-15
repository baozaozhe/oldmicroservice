package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.PermissFile;
import com.qhzk.as.mapper.PermissFileMapper;
import com.qhzk.as.service.PermissFileService;
import org.springframework.stereotype.Service;

/**
 * 权限-文件信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class PermissFileServiceImpl extends ServiceImpl<PermissFileMapper,PermissFile> implements PermissFileService {
	@Resource
	private PermissFileMapper permissfilemapper;
}
