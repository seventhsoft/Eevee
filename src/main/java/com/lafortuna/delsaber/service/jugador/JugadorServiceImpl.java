/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.jugador;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.model.Concurso;
import com.lafortuna.delsaber.model.JugadorNivel;
import com.lafortuna.delsaber.repository.ConcursoMapper;
import com.lafortuna.delsaber.repository.JugadorNivelMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cliente
 */
@Service
public class JugadorServiceImpl extends GenericService implements JugadorService {
    
    @Autowired
    private ConcursoMapper concursoMapper;
    
    @Autowired
    private JugadorNivelMapper jugadorNivelMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> getFechaConcursoActual(Authentication auth) { 
        Map<String, Object> result = new HashMap<>();
        Concurso concurso = this.concursoMapper.getFechaConcursoActual();
        if(validaConcurso(concurso)) {
            result.put("concurso", concurso);
            
            Integer idJugador = this.getidJugadorByUser(auth);
            JugadorNivel jugadorNivel = this.jugadorNivelMapper.getJugadorNivelByIdJugador(idJugador);
            
            if(objetoValido(jugadorNivel)) {
                result.put("concurso", concurso);
            } else {
                jugadorNivel.setIdJugadorNivel(idJugador);
                jugadorNivel.setSerieActual(Constant.SERIE_UNO);
            }
        }
        return result;
    }
    
    public boolean validaConcurso(Concurso concurso) {
        if(objetoValido(concurso)) {
            return Boolean.TRUE;
        }
        throw new InternalServerException("No hay concurso disponible");
    }
    
}
