package com.qingqiao.vhrboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.qingqiao.vhr.mapper")
@ComponentScan("com.qingqiao.vhr")
@EnableCaching
class VhrbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrbootApplication.class, args);
    }

}
