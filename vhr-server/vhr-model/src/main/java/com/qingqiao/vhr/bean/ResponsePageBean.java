package com.qingqiao.vhr.bean;

import java.util.List;

public class ResponsePageBean {
    private List<?> data;
    private Integer total;

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
