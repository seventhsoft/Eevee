/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.configuration.Application;
import com.lafortuna.delsaber.util.Constant;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 *
 * @author Cliente
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestMailService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public JavaMailSender javaMailSender;
    
    @Autowired
    public MailContentBuilder mailContentBuilder;
    
    @Test
    public void sendMailTest() {
      /*  SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("mario.mtz0310@gmail.com");
        mailMessage.setSubject("Test Spring");
        mailMessage.setText("Test Spring Body Message");
        mailMessage.setFrom("info@juegakuni.mx");
        javaMailSender.send(mailMessage); */
       
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("info@juegakuni.mx");
            messageHelper.setTo("mario.mtz0310@gmail.com");
            messageHelper.setSubject("Test Spring");
            Map<String, String> params = new HashMap<>();
            params.put("message", "Test Message HTML!");
            String content = mailContentBuilder.build(Constant.TEST_MAIL_TEMPLATE, params);
            messageHelper.setText(content, true);
        };
        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            log.error(this.getClass().getName() + "Error al mandar correo html " + e);
        }
        assertThat(javaMailSender).isNotNull();
    }
    
}
