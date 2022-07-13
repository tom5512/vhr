package com.qingqiao.vhr.utils;

public class ResponseBean {
    private Integer status;
    private String msg;
    private Object obj;

    private ResponseBean() {
    }

    public static ResponseBean ok(String msg){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(200);
        responseBean.setMsg(msg);
        return responseBean;
    }
    public static ResponseBean ok(String msg,Object obj){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(200);
        responseBean.setMsg(msg);
        responseBean.setObj(obj);
        return responseBean;
    }
    public static ResponseBean error(String msg){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(500);
        responseBean.setMsg(msg);
        return responseBean;
    }
    public static ResponseBean error(String msg,Object obj){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setStatus(500);
        responseBean.setObj(obj);
        responseBean.setMsg(msg);
        return responseBean;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
