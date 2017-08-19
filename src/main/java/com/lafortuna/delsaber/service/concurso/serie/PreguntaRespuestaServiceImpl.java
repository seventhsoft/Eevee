/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.model.JugadorNivel;
import com.lafortuna.delsaber.model.Nivel;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.repository.JugadorNivelMapper;
import com.lafortuna.delsaber.repository.NivelMapper;
import com.lafortuna.delsaber.repository.PreguntaRespuestaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import groovy.transform.Synchronized;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author cliente
 */
@Service
public class PreguntaRespuestaServiceImpl extends GenericService implements PreguntaRespuestaService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PreguntaRespuestaMapper preguntaRespuestaMapper;
    
    @Autowired
    private NivelMapper nivelMapper;
    
    @Autowired
    private JugadorNivelMapper jugadorNivelMapper;

    @Override
    @Synchronized
    public Recompensa insertSerie(Map<String, Integer> map, Authentication auth) {
        Integer jugadorNivel = map.get("idJugadorNivel");
        Integer respuesta = map.get("idRespuesta");
        Integer serie = map.get("serie");
        Integer perfecta = map.get("perfecta");
        Integer idConcurso = map.get("idConcurso");
        Recompensa recompensa = new Recompensa();
        try{
            this.preguntaRespuestaMapper.insertSerie(jugadorNivel, respuesta, serie);
            if(perfecta == Constant.SERIE_PERFECTA){
                this.avanzaSerie(auth,jugadorNivel,serie,idConcurso);
            }
            recompensa = this.preguntaRespuestaMapper.getRecompensaConcurso(jugadorNivel);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + ":insertSerie ex:" + e);
            throw new InternalServerException("Error al guardar serie: "+e);
        }
        return recompensa;
    }
    
    private String avanzaSerie(Authentication auth,Integer jugadorNivel,Integer serie,Integer idConcurso){
        Nivel nivel = this.nivelMapper.getNivelByJugadorNivel(jugadorNivel);
        Integer serieActual = serie + 1;
        Integer nivelActual = nivel.getNivel()+1;
        if(nivel.getSeries() <= serieActual){
            Integer totalNiveles = this.nivelMapper.getTotalNivelesByIdConcurso(idConcurso);
            if(nivelActual<= totalNiveles){
                //Avanza nivel
                Integer idJugador = getIdJugadorByUser(auth);
                JugadorNivel jn = new JugadorNivel();
                jn.setIdConcurso(idConcurso);
                jn.setdNivel(nivelActual);
                jn.setSerieActual(serieActual);
                jn.setIdJugador(idJugador);
                this.jugadorNivelMapper.subirNivel(jn);
                nivel = this.nivelMapper.getNivelByJugadorNivel(jugadorNivel);
                return this.ganaPremio(jn,nivel);
            }
            return "";
        }else{
            //Avanza serie
            this.jugadorNivelMapper.subirSerie(jugadorNivel, serieActual);
            return "";
        }
    }
    
    private String ganaPremio(JugadorNivel jugadorNivel, Nivel nivel){
        
        return "";
    }
    
}
