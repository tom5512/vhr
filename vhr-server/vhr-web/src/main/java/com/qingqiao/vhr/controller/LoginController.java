package com.qingqiao.vhr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public String toLogin() throws JsonProcessingException {
            ResponseBean error = ResponseBean.error("请先登录");
            ObjectMapper objectMapper = new ObjectMapper();
            String string = objectMapper.writeValueAsString(error);
            return string;
    }

//    @GetMapping("/employee/basic/hello")
//    public String hello1(){
//        return "hello11111111111111111111111111";
//    }
//    @GetMapping("/employee/advanced/hello")
//    public String hello2(){
//        return "hello222222222222222222222222222222";
//    }
}
