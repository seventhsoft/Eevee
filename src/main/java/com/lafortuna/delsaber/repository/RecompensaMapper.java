/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Recompensa;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author Andres
 */
@Mapper
public interface RecompensaMapper {
        
    List<Recompensa> getRecompensasByConcurso(Integer idConcurso);
    
    
    List<Recompensa> getRecompensasByJugador(Integer idJugador, Integer idConcurso);
}
