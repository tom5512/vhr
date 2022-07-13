package com.qingqiao.vhr.mapper;

import com.qingqiao.vhr.bean.Hr;
import com.qingqiao.vhr.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    UserDetails loadUserByUsername(String username);

    List<Role> getRolesByHrId(Integer hrid);
}