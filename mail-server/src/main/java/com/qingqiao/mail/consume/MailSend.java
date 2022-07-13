package com.qingqiao.mail.consume;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingqiao.vhr.bean.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
@RabbitListener(queues = "qingqiao.mail.welcome")
public class MailSend {

    @Autowired
    public JavaMailSender javamailSender;

    @Autowired
    public TemplateEngine templateEngine;

    @RabbitHandler
    @RabbitListener(queues = "qingqiao.mail.welcome")
    public void consume(Employee employee){
        MimeMessage mimeMessage = javamailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom("1187866400@qq.com");

            helper.setTo(employee.getEmail());

            helper.setSentDate(new Date());

            helper.setSubject("欢迎入职");
            Context context = new Context();
            context.setVariable("empName", employee.getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("jobLevelName", employee.getJobLevel().getName());
            String process = templateEngine.process("mail.html", context);


            helper.setText(process,true);


            javamailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }


}
