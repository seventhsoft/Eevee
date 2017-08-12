/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import com.lafortuna.delsaber.repository.PreguntaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cliente
 */
@Service
public class SerieServiceImpl extends GenericService{
    
    @Autowired
    private PreguntaMapper preguntaMapper;
    
    public Map<String, Object> getSerieByJugador(Authentication auth) {
        Map<Integer, Map<String, Integer>> proporcionPreguntas = this.preguntaMapper.getProporcionPreguntas(getIdJugadorByUser(auth));
        
        computePortion(proporcionPreguntas);    
        return new HashMap<>();
    }
    
    public void computePortion(Map<Integer, Map<String, Integer>> proporcionPreguntas) {
        
        Integer totalPorcion = getTotalPorcion(proporcionPreguntas);
        
        Integer facil = proporcionPreguntas.get(Constant.DIFICULTAD_FACIL).get("preguntas");
        Integer media = proporcionPreguntas.get(Constant.DIFICULTAD_MEDIA).get("preguntas");
        Integer dificl = proporcionPreguntas.get(Constant.DIFICULTAD_DIFICIL).get("preguntas");
        
        if(!totalPorcion.equals(Constant.TOTAL_PREGUNTAS_POR_SERIE)) {            
            if(totalPorcion < Constant.TOTAL_PREGUNTAS_POR_SERIE) { 
                
            } else if(totalPorcion > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
                while(!getTotalPorcion(proporcionPreguntas).equals(Constant.TOTAL_PREGUNTAS_POR_SERIE)) {
                    computePortionBigger(facil, media, dificl, proporcionPreguntas);
                }
            } 
            facil = proporcionPreguntas.get(Constant.DIFICULTAD_FACIL).get("preguntas");
            media = proporcionPreguntas.get(Constant.DIFICULTAD_MEDIA).get("preguntas");
            dificl = proporcionPreguntas.get(Constant.DIFICULTAD_DIFICIL).get("preguntas");
        } 
        computePortionEqual(facil, media, dificl, proporcionPreguntas);
    }
    
    public void computePortionEqual(int facil, int media, int dificl, Map<Integer, Map<String, Integer>> proporcionPreguntas) {
        if(media > facil && media > dificl) {
            proporcionPreguntas.get(Constant.DIFICULTAD_MEDIA).put("preguntas", media-1);
            proporcionPreguntas.get(Constant.DIFICULTAD_FACIL).put("preguntas", facil+1);
        }
        if(dificl > facil && dificl > media) {
            proporcionPreguntas.get(Constant.DIFICULTAD_DIFICIL).put("preguntas", dificl-1);
            proporcionPreguntas.get(Constant.DIFICULTAD_FACIL).put("preguntas", facil+1);
        }
    }
    
    public void computePortionBigger(int facil, int media, int dificl, Map<Integer, Map<String, Integer>> proporcionPreguntas) {
        if(facil > media && facil > dificl && getTotalPorcion(proporcionPreguntas) > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
            proporcionPreguntas.get(Constant.DIFICULTAD_FACIL).put("preguntas", facil-1);
        }
        if(media > facil && media > dificl && getTotalPorcion(proporcionPreguntas) > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
            proporcionPreguntas.get(Constant.DIFICULTAD_MEDIA).put("preguntas", media-1);
        }
        if(dificl > facil && dificl > media && getTotalPorcion(proporcionPreguntas) > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
            proporcionPreguntas.get(Constant.DIFICULTAD_DIFICIL).put("preguntas", dificl-1);
        }
    }
    
    public Integer getTotalPorcion(Map<Integer, Map<String, Integer>> proporcionPreguntas) {
        return proporcionPreguntas.get(Constant.DIFICULTAD_FACIL).get("preguntas") +
                               proporcionPreguntas.get(Constant.DIFICULTAD_MEDIA).get("preguntas") +
                               proporcionPreguntas.get(Constant.DIFICULTAD_DIFICIL).get("preguntas");
    }

}
