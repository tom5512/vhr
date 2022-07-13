package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.Department;
import com.qingqiao.vhr.utils.ResponseBean;

import java.util.List;

public interface DeptService {
    List<Department> getAllDept();

    int insertDept(Department department);

    ResponseBean deleteDept(Integer id);

    List<Department> getDept(ResponseBean responseBean);
}
