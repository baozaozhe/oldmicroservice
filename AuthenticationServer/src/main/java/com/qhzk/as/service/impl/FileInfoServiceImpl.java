package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.FileInfo;
import com.qhzk.as.mapper.FileInfoMapper;
import com.qhzk.as.service.FileInfoService;
import org.springframework.stereotype.Service;

/**
 * 文件信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper,FileInfo> implements FileInfoService {
	@Resource
	private FileInfoMapper fileinfomapper;
}
