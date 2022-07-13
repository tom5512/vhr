package com.qingqiao.vhr.mapper;

import com.qingqiao.vhr.bean.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenuByHrId(Integer hrid);

    List<Menu> getAllMenuByRid();

    List<Menu> getAllMenus();

    List<Menu> getAllMenusByRID(Integer rid);
}