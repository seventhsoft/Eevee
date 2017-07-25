/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.configuration;

import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;

/**
 *
 * @author Cliente
 */
@Configuration
@Profile("qa")
@PropertySource("classpath:application-qa.properties")
public class HirakiCPQAConf {
    
    @Autowired
    Environment environment;
    
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatFactory(){
        return new TomcatEmbeddedServletContainerFactory() {
            
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat){
               tomcat.enableNaming();
               return super.getTomcatEmbeddedServletContainer(tomcat);
            }
            
            @Override
            protected void postProcessContext(Context context) {
                ContextResource resource = new ContextResource();
                resource.setName(environment.getProperty("jndi.name"));
                resource.setType(environment.getProperty("spring.datasource.type"));
                resource.setProperty("factory", environment.getProperty("jndi.factory"));
                resource.setProperty("driverClassName", environment.getProperty("hikari.driverClassName"));
                resource.setProperty("jdbcUrl", environment.getProperty("hikari.url"));
                resource.setProperty("username", environment.getProperty("hikari.username"));
                resource.setProperty("password", environment.getProperty("hikari.password"));
                
                context.getNamingResources().addResource(resource);
            }
        };
    }
    
    @Bean(destroyMethod = "")
    public DataSource jndiDataSource() throws IllegalArgumentException, NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/" + environment.getProperty("jndi.name"));
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }
}
