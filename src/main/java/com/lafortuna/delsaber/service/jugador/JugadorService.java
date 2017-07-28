/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.jugador;

import java.util.Map;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Cliente
 */
public interface JugadorService {
    Map<String, Object> getFechaConcursoActual(Authentication auth);
}
