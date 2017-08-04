/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.util.Constant;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cliente
 */
@Component
public class MailService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    public JavaMailSender javaMailSender;
    
    @Autowired
    public MailContentBuilder mailContentBuilder;
    
    @Async
    public void enviaCorreoRegistro(String toMail, String parametros) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("info@juegakuni.mx");
            messageHelper.setTo(toMail);
            messageHelper.setSubject("Bienvenido a Kuni!");
            Map<String, String> params = new HashMap<>();
            params.put("ruta",Constant.RUTA_HOME_KUNI);
            params.put("parametros", parametros);
            String content = mailContentBuilder.build(Constant.RESGISTRO_MAIL_TEMPLATE, params);
            messageHelper.setText(content, true);
        };
        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            log.error(this.getClass().getName() + "Error al mandar correo html " + e);
        }
    }
    
    @Async
    public void enviaCorreoRecuperar(String toMail, String usuario, String parametros){
        MimeMessagePreparator messagePreparator = mimeMessage ->{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("info@juegakuni.mx");
            messageHelper.setTo(toMail);
            messageHelper.setSubject("Completa tu solicitud de restablecimiento de contrase\u00f1a");
            Map<String, String> params = new HashMap<>();
            params.put("usuario", usuario);
            params.put("ruta",Constant.RUTA_HOME_KUNI);
            params.put("parametros", parametros);
            String content = mailContentBuilder.build(Constant.RECUPERAR_MAIL_TEMPLATE, params);
            messageHelper.setText(content, true);
        };
        try{
            javaMailSender.send(messagePreparator);
        } catch (MailException e){
            log.error(this.getClass().getName() + "Error al mandar recuperar html " + e);
        }
    }
}
