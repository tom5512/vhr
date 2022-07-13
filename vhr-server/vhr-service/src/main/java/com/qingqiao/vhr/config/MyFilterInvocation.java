package com.qingqiao.vhr.config;

import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.bean.Role;
import com.qingqiao.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class MyFilterInvocation implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuMapper menuMapper;

    AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        FilterInvocation filterInvocation=(FilterInvocation) o;
        String requestUrl = filterInvocation.getRequestUrl();
        List<Menu> menus=menuMapper.getAllMenuByRid();
        for (Menu menu : menus) {
            if(antPathMatcher.match(menu.getUrl(), requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] roleNames = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    roleNames[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleNames);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
