package com.qingqiao.vhr.mapper;

import com.qingqiao.vhr.bean.Employee;
import com.qingqiao.vhr.bean.JobLevel;
import com.qingqiao.vhr.bean.Nation;
import com.qingqiao.vhr.bean.Politicsstatus;
import com.qingqiao.vhr.utils.ResponseBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getAllEmp(@Param("page") Integer page, @Param("size") Integer size,@Param("name") String name);

    Integer getTotal(String name);

    int deleteEmpMany(@Param("ids") Integer[] ids);

    List<Nation> getNation(ResponseBean responseBean);

    List<Politicsstatus> getPol(ResponseBean responseBean);

    List<Employee> queryall();

    Employee getEmpById(Integer id);
}