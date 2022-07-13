package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.bean.Position;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuByHrId();

    List<Menu> getAllMenus();

    List<Menu> getAllMenusByRID(Integer rid);


}
