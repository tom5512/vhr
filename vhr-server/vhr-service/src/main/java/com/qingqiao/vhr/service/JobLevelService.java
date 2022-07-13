package com.qingqiao.vhr.service;

import com.qingqiao.vhr.bean.JobLevel;
import com.qingqiao.vhr.utils.ResponseBean;

import java.util.List;

public interface JobLevelService {
    List<JobLevel> gerAllJobLevels();

    int addJobLevel(JobLevel jobLevel);

    int updateJobLevel(JobLevel jobLevel);

    int deleteJobLevel(Integer id);

    int deleteManyJobLevel(Integer[] ids);

    List<JobLevel> getTitleLevel(ResponseBean responseBean);
}
