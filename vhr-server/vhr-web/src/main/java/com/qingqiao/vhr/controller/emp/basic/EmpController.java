package com.qingqiao.vhr.controller.emp.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.*;
import com.qingqiao.vhr.service.EmployeeService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @GetMapping("/emp")
    public ResponsePageBean getAllEmp(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer size,@RequestParam(defaultValue = "") String name){
        ResponsePageBean bean = employeeService.getAllEmp(page,size,name);
        return bean;
    }
    @GetMapping("/emp/nation")
    public List<Nation> getNation(ResponseBean responseBean){
        List<Nation> bean=employeeService.getNation(responseBean);
        return bean;
    }

    @GetMapping("/emp/pol")
    public List<Politicsstatus> getPol(ResponseBean responseBean){
        List<Politicsstatus> bean=employeeService.getPol(responseBean);
        return bean;
    }

    @PostMapping("/emp")
    public ResponseBean insertEmp(@RequestBody Employee employee) throws JsonProcessingException {
        if(employeeService.insertEmp(employee)==1){
            Employee e=employeeService.getEmpById(employee.getId());
//            ObjectMapper objectMapper = new ObjectMapper();
//            String string = objectMapper.writeValueAsString(e);
            rabbitTemplate.convertAndSend("qingqiao.mail.welcome",e);
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.ok("添加失败!");
    }

    @PutMapping("/emp")
    public ResponseBean updateEmp(@RequestBody Employee employee){
        if(employeeService.updateEmp(employee)==1){
            return ResponseBean.ok("修改成功!");
        }
        return ResponseBean.ok("修改失败!");
    }

    @DeleteMapping("/emp/{id}")
    public ResponseBean deleteEmp(@PathVariable Integer id){
        if(employeeService.deleteEmp(id)==1){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.ok("删除失败!");
    }

    @DeleteMapping("/emp/many/{ids}")
    public ResponseBean deleteEmpMany(@PathVariable Integer[] ids){
        if(employeeService.deleteEmpMany(ids) == ids.length){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

}
