package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Menu;
import com.qingqiao.vhr.bean.Position;
import com.qingqiao.vhr.service.MenuService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/menus")
    public String getAllMenus() throws JsonProcessingException {
        List<Menu> menus=menuService.getAllMenus();
        return new ObjectMapper().writeValueAsString(menus);
    }
    @GetMapping("/menus/{rid}")
    public String getAllMenusByRID(@PathVariable Integer rid) throws JsonProcessingException {
        List<Menu> menus=menuService.getAllMenusByRID(rid);
        return new ObjectMapper().writeValueAsString(menus);
    }



}
