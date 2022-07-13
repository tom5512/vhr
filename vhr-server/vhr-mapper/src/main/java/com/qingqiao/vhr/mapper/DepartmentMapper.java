package com.qingqiao.vhr.mapper;

import com.qingqiao.vhr.bean.Department;
import com.qingqiao.vhr.utils.ResponseBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDept();

    Department selectDeptById(Integer id);

    List<Department> getDept(ResponseBean responseBean);
}