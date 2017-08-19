/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import java.util.Map;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Cliente
 */
public interface SerieService {
    Map<String, Object> getSerieByJugador(Authentication auth, Integer idJugadorNivel);
}
