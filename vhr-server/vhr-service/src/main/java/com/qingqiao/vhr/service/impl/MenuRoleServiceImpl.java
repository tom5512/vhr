package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.mapper.MenuRoleMapper;
import com.qingqiao.vhr.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;



    @Override
    public boolean insertMenuRole(Integer rid, Integer[] mids) {
        int deleteResult = menuRoleMapper.deleteMenuRoleByRid(rid);
        int insertResult = menuRoleMapper.insertMenuRole(rid, mids);
        return deleteResult>0 & insertResult>0;
    }
}
