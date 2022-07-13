package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Role;
import com.qingqiao.vhr.service.RoleService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("system/basic")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role")
    public String getAllRoles() throws JsonProcessingException {
        List<Role> list=roleService.getAllRoles();
        return new ObjectMapper().writeValueAsString(list);
    }
    @PostMapping("/role")
    public ResponseBean insertRoles(@RequestBody Role role){
        if(roleService.insertRoles(role)==1){
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }
    @PutMapping("/role")
    public ResponseBean updateRoles(@RequestBody Role role){
        if(roleService.updateRoles(role)==1){
            return ResponseBean.ok("修改成功!");
        }
        return ResponseBean.error("修改失败!");
    }
    @DeleteMapping("/role/{id}")
    public ResponseBean deleteRoles(@PathVariable Integer id){
        if(roleService.deleteRoles(id)==1){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }
}
