/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.lafortuna.delsaber.configuration.Application;
import com.lafortuna.delsaber.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author mariomartinezaguilar
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TestService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioService usuarioService;    
    
    @Test
    public void testPrint() {
        Usuario usuario = usuarioService.getUsuarioByUserName("admin");
        assertThat(usuario).isNotNull();
    }
    
    
}
