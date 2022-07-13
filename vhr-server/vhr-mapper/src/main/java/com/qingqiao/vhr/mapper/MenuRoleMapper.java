package com.qingqiao.vhr.mapper;

import com.qingqiao.vhr.bean.MenuRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    int deleteMenuRoleByRid(Integer rid);

    int insertMenuRole(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}