package com.qhzk.as.service.impl;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhzk.as.entity.Menu;
import com.qhzk.as.mapper.MenuMapper;
import com.qhzk.as.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单信息 Service实现类
 * @author: Mr.Muxl
 * @date 2021-08-05
 */

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper,Menu> implements MenuService {
	@Resource
	private MenuMapper menumapper;
}
