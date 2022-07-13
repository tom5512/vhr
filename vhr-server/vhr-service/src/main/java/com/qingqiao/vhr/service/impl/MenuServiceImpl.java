package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.Hr;
import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.bean.Position;
import com.qingqiao.vhr.config.SecurityConfig;
import com.qingqiao.vhr.mapper.MenuMapper;
import com.qingqiao.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getMenuByHrId() {
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Menu> menuByHrId = menuMapper.getMenuByHrId(hr.getId());
        return menuByHrId;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Override
    public List<Menu> getAllMenusByRID(Integer rid) {
        return menuMapper.getAllMenusByRID(rid);
    }


}
