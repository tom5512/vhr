package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.Hr;
import com.qingqiao.vhr.mapper.HrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    private HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = (Hr) hrMapper.loadUserByUsername(s);
        if(hr==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        hr.setRoles(hrMapper.getRolesByHrId(hr.getId()));
        return hr;
    }
}
