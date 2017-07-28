/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.jugador;

import com.lafortuna.delsaber.rest.GenericRestService;
import com.lafortuna.delsaber.service.jugador.JugadorService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/jugador")
public class JugadorRestService extends GenericRestService{
    
    @Autowired
    private JugadorService jugadorService;
    
    @RequestMapping(value = "/concurso", method = RequestMethod.GET)
    public Map<String, Object> getFechaConcursoActual(Authentication auth) {       
        return this.jugadorService.getFechaConcursoActual(auth);        
    }
    
}
