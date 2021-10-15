package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Company;
import com.qhzk.as.mapper.CompanyMapper;
import com.qhzk.as.service.CompanyService;
import org.springframework.stereotype.Service;

/**
 * 公司信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper,Company> implements CompanyService {
	@Resource
	private CompanyMapper companymapper;
}
