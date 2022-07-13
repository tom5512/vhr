package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    int insertRoles(Role role);

    int deleteRoles(Integer id);

    int updateRoles(Role role);
}
