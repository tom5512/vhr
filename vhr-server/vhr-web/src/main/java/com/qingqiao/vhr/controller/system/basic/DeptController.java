package com.qingqiao.vhr.controller.system.basic;

import com.qingqiao.vhr.bean.Department;
import com.qingqiao.vhr.service.DeptService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept")
    public List<Department> getAllDept(){
        return deptService.getAllDept();
    }
    @GetMapping("/dept/name")
    public List<Department> getDept(ResponseBean responseBean){
        return deptService.getDept(responseBean);
    }

    @PostMapping("/dept")
    public ResponseBean insertDept(@RequestBody Department department){
        if(deptService.insertDept(department)>0){
            return ResponseBean.ok("添加成功！");
        }
        return ResponseBean.error("添加失败！");
    }

    @DeleteMapping("/dept/{id}")
    public ResponseBean deleteDept(@PathVariable Integer id){
        return deptService.deleteDept(id);
    }
}
