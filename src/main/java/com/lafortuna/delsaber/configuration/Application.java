/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *
 * @author mario.martinez
 */
@EnableAsync
@SpringBootApplication
//@EnableJpaRepositories(basePackages = "org.mario.springboot.repository")
//@EntityScan(basePackages = "org.mario.springboot.model")
@ComponentScan(basePackages = {"com.lafortuna.delsaber.rest", "com.lafortuna.delsaber.service","com.lafortuna.delsaber.configuration", "com.lafortuna.delsaber.task"})
@MapperScan("com.lafortuna.delsaber.repository")
public class Application {
    public static void main(String ... args) throws Throwable
    {
        SpringApplication.run(Application.class, args);
    }
    
}
