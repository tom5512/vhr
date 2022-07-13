package com.qingqiao.vhr.service.impl;

import com.qingqiao.vhr.bean.JobLevel;
import com.qingqiao.vhr.mapper.JobLevelMapper;
import com.qingqiao.vhr.service.JobLevelService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    private JobLevelMapper jobLevelMapper;


    @Override
    public List<JobLevel> gerAllJobLevels() {
        return jobLevelMapper.gerAllJobLevels();
    }

    @Override
    public int addJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.insertSelective(jobLevel);
    }

    @Override
    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateByPrimaryKeySelective(jobLevel);
    }

    @Override
    public int deleteJobLevel(Integer id) {
        return jobLevelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteManyJobLevel(Integer[] ids) {
        return jobLevelMapper.deleteManyJobLevel(ids);
    }

    @Override
    public List<JobLevel> getTitleLevel(ResponseBean responseBean) {
        return jobLevelMapper.getTitleLevel(responseBean);
    }
}
