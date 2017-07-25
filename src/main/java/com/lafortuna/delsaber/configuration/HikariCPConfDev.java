/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.configuration;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author mario.martinez
 */
@Configuration
@Profile("dev")
public class HikariCPConfDev {
    
    @Value("${hikari.driverClassName}")
    private String driverClassName;

    @Value("${hikari.url}")
    private String jdbcUrl;

    @Value("${hikari.username}")
    private String userName;

    @Value("${hikari.password}")
    private String password;

    @Value("${hikari.pool.size}")
    private int poolSize;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(poolSize);
        ds.setDriverClassName(driverClassName);
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
