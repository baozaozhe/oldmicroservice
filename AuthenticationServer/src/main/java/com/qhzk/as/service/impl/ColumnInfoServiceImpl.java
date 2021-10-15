package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.ColumnInfo;
import com.qhzk.as.mapper.ColumnInfoMapper;
import com.qhzk.as.service.ColumnInfoService;
import org.springframework.stereotype.Service;

/**
 * 列的数据信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-29
 */

@Service
public class ColumnInfoServiceImpl extends ServiceImpl<ColumnInfoMapper,ColumnInfo> implements ColumnInfoService {
	@Resource
	private ColumnInfoMapper columninfomapper;
}
