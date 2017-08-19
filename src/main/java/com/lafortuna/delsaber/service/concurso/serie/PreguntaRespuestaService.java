/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import com.lafortuna.delsaber.model.Recompensa;
import java.util.Map;

/**
 *
 * @author cliente
 */
public interface PreguntaRespuestaService {
    
    Recompensa insertSerie(Map<String, Integer> map);
    
}
