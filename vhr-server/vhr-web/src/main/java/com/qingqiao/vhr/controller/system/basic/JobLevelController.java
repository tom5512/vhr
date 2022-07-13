package com.qingqiao.vhr.controller.system.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.JobLevel;
import com.qingqiao.vhr.service.JobLevelService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic")
public class JobLevelController {
    @Autowired
    private JobLevelService jobLevelService;


    @GetMapping("/job")
    public String gerAllJobLevels() throws JsonProcessingException {
        List<JobLevel> list=jobLevelService.gerAllJobLevels();
        return new ObjectMapper().writeValueAsString(list);
    }

    @GetMapping("/job/level")
    public List<JobLevel> getTitleLevel(ResponseBean responseBean){
        List<JobLevel>  bean=jobLevelService.getTitleLevel(responseBean);
        return bean;
    }


    @PostMapping("/job")
    public ResponseBean addJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevel(jobLevel)==1){
            return ResponseBean.ok("添加成功!");
        }
        return ResponseBean.error("添加失败!");
    }

    @PutMapping("/job")
    public ResponseBean updateJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updateJobLevel(jobLevel)==1){
            return ResponseBean.ok("修改成功!");
        }
        return ResponseBean.error("修改失败!");
    }
    @DeleteMapping("/job/{id}")
    public ResponseBean deleteJobLevel(@PathVariable Integer id){
        if (jobLevelService.deleteJobLevel(id)==1){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }

    @DeleteMapping("/jobs/{ids}")
    public ResponseBean deleteManyJobLevel(@PathVariable Integer[] ids){
        if (jobLevelService.deleteManyJobLevel(ids)==ids.length){
            return ResponseBean.ok("删除成功!");
        }
        return ResponseBean.error("删除失败!");
    }



}
