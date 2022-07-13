package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.*;
import com.qingqiao.vhr.utils.ResponseBean;

import java.util.List;

public interface EmployeeService {
    ResponsePageBean getAllEmp(Integer page, Integer size, String name);

    int insertEmp(Employee employee);

    int deleteEmp(Integer id);

    int deleteEmpMany(Integer[] ids);

    int updateEmp(Employee employee);

    List<Nation> getNation(ResponseBean responseBean);

    List<Politicsstatus> getPol(ResponseBean responseBean);

    Employee getEmpById(Integer id);
}
