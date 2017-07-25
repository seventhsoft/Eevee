/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.configuration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 *
 * @author Cliente
 */
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.POST, "/usuarios").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/usuarios").hasAnyRole("ADMIN", "JUGADOR", "PATROCINADOR", "ANUNCIANTE");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/usuarios").hasAnyRole("ADMIN", "JUGADOR", "PATROCINADOR", "ANUNCIANTE");
        http.authorizeRequests().antMatchers(HttpMethod.PUT, "/usuarios").hasAnyRole("ADMIN", "JUGADOR", "PATROCINADOR", "ANUNCIANTE");
    }
    
}
