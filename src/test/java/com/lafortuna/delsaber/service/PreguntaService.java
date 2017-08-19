/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.configuration.Application;
import com.lafortuna.delsaber.repository.PreguntaMapper;
import static com.lafortuna.delsaber.repository.provider.UserProvider.usuario;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Cliente
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PreguntaService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PreguntaMapper preguntaMapper;
    
    @Test
    public void testPrint() {
       // Map<Integer, Map<String, Integer>> rList = this.preguntaMapper.getProporcionPreguntas(1);

    }
    
}
