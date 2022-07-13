package com.qingqiao.mail.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    Queue queue(){
        return new Queue("qingqiao.mail.welcome");
    }

    @Bean
    public FanoutExchange emailExchange(){
        return new FanoutExchange("email-queue",true,false);
    }

    @Bean
    public BindingBuilder.DestinationConfigurer bindingEmailDirect(){
        return BindingBuilder.bind(queue());
    }

}
