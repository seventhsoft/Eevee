/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

/**
 *
 * @author cliente
 */
public interface PreguntaRespuestaService {
    
    ResponseEntity<?> insertSerie(Map<String, Integer> map, Authentication auth);
    
}
