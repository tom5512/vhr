package com.qingqiao.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Hr;
import com.qingqiao.vhr.service.impl.HrService;
import com.qingqiao.vhr.utils.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private HrService hrService;
    @Autowired
    private MyFilterInvocation myFilterInvocation;
    @Autowired
    private MyDecisionManger myDecisionManger;


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(myFilterInvocation);
                        o.setAccessDecisionManager(myDecisionManger);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/doLogin")
                .successHandler((httpServletRequest, httpServletResponse, authentication) ->{
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    Hr hr =(Hr) authentication.getPrincipal();
                    hr.setPassword("");
                    ResponseBean ok = ResponseBean.ok("登录成功", hr);
                    ObjectMapper objectMapper = new ObjectMapper();
                    String str=objectMapper.writeValueAsString(ok);
                    httpServletResponse.getWriter().print(str);
                } )
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = httpServletResponse.getWriter();
                    ResponseBean error=ResponseBean.error(e.getMessage());
                    if (e instanceof LockedException) {
                        error.setMsg("账户被锁定，请联系管理员!");
                    } else if (e instanceof CredentialsExpiredException) {
                        error.setMsg("密码过期，请联系管理员!");
                    }else if (e instanceof AccountExpiredException) {
                        error.setMsg("账户过期，请联系管理员!");
                    }else if (e instanceof DisabledException) {
                        error.setMsg("账户被禁用，请联系管理员!");
                    } else if (e instanceof BadCredentialsException) {
                        error.setMsg("用户名或者密码输入错误，请重新输入!");
                    }
                    ObjectMapper objectMapper = new ObjectMapper();
                    String str=objectMapper.writeValueAsString(error);
                    httpServletResponse.getWriter().print(str);

                })
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    ObjectMapper objectMapper = new ObjectMapper();
                    ResponseBean ok = ResponseBean.ok("注销成功！");
                    String str = objectMapper.writeValueAsString(ok);
                    httpServletResponse.getWriter().print(str);

                })
                .and()
                .cors()
                .and()
                .csrf()
                .disable();
    }
}
