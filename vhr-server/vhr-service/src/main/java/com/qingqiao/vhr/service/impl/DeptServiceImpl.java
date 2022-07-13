package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.Department;
import com.qingqiao.vhr.mapper.DepartmentMapper;
import com.qingqiao.vhr.service.DeptService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDept() {
        return departmentMapper.getAllDept();
    }

    @Override
    public int insertDept(Department department) {
        int i = departmentMapper.insertSelective(department);
        System.out.println(department);
        Integer parentId = department.getParentId();
        System.out.println("parentid="+parentId);
        Department parentDept = departmentMapper.selectByPrimaryKey(department.getParentId());

        department.setDepPath(parentDept.getDepPath()+"."+department.getId());
        System.out.println(parentDept);
        int i1 = departmentMapper.updateByPrimaryKeySelective(department);

        parentDept.setParent(true);
        int i2 = departmentMapper.updateByPrimaryKeySelective(parentDept);
        return i2;
    }

    @Override
    public ResponseBean deleteDept(Integer id) {
        Department dept=departmentMapper.selectDeptById(id);
        if(dept.getEmployees().size() != 0){
            return ResponseBean.error("该部门下有员工,删除失败!");
        }else if (dept.getParent()){
            return ResponseBean.error("该部门下有子部门,删除失败!");
        }
        int i= departmentMapper.deleteByPrimaryKey(id);
        if (i>0){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

    @Override
    public List<Department> getDept(ResponseBean responseBean) {
        return departmentMapper.getDept(responseBean);
    }
}
