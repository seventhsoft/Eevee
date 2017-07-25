/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 *
 * @author Cliente
 */
@Configuration
public class ThymeleafConfigurator {
    
    @Bean
    public ClassLoaderTemplateResolver emailTemplateResolver() {
            ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
            emailTemplateResolver.setPrefix("mails/");
            emailTemplateResolver.setSuffix(".html");
            emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
            emailTemplateResolver.setCharacterEncoding("UTF-8");
            emailTemplateResolver.setOrder(0);
            emailTemplateResolver.setCheckExistence(true);

            return emailTemplateResolver;
	}
}
