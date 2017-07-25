/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author Cliente
 */
@Service
public class MailContentBuilder {
    
    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String template, Map<String, String> params) {
        Context context = new Context();
        if(params != null) {
            params.entrySet().forEach(e -> {
                context.setVariable(e.getKey(), e.getValue());
            });       
        }
        return templateEngine.process(template, context);
    }
}
