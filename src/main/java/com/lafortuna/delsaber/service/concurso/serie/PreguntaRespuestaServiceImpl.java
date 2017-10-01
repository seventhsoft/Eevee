/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.model.JugadorNivel;
import com.lafortuna.delsaber.model.JugadorRecompensa;
import com.lafortuna.delsaber.model.Nivel;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.model.RecompensaConcursoNivelDTO;
import com.lafortuna.delsaber.repository.JugadorNivelMapper;
import com.lafortuna.delsaber.repository.JugadorRecompensaMapper;
import com.lafortuna.delsaber.repository.NivelMapper;
import com.lafortuna.delsaber.repository.PreguntaRespuestaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import groovy.transform.Synchronized;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @Autowired
    private JugadorRecompensaMapper jugadorRecompensaMapper;

    @Override
    @Synchronized
    public ResponseEntity<?> insertSerie(Map<String, Integer> map, Authentication auth) {
        Integer jugadorNivel = map.get("idJugadorNivel");
        Integer respuesta = map.get("idRespuesta");
        Integer serie = map.get("serie");
        Integer perfecta = map.get("perfecta");
        Integer idConcurso = map.get("idConcurso");
        try{
            this.preguntaRespuestaMapper.insertSerie(jugadorNivel, respuesta, serie);
            JugadorNivel jugadorNivelDTO = this.avanzaSerie(auth,jugadorNivel,serie,idConcurso,perfecta);            
            Recompensa recompensa = this.preguntaRespuestaMapper.getRecompensaConcurso(jugadorNivel);
            Map<String,Object> result;
            result = new HashMap<>();
            result.put("recompensa", recompensa);
            result.put("jugadorNivel", jugadorNivelDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + ":insertSerie ex:" + e);
            throw new InternalServerException("Error al guardar serie: "+e);
        }
    }
    
    private JugadorNivel avanzaSerie(Authentication auth,Integer jugadorNivel,Integer serie,Integer idConcurso, Integer perfecta){
        Nivel nivel = this.nivelMapper.getNivelByJugadorNivel(jugadorNivel);
        Integer serieActual = serie + 1;
        Integer nivelActual = nivel.getNivel()+1;
        JugadorNivel jn = new JugadorNivel();
        Integer idJugador = getIdJugadorByUser(auth);
        String recompensaGanada = ""; 
        Boolean ban = perfecta == Constant.SERIE_PERFECTA;
        if(ban){
            log.info("es perfecta");
            if(serieActual > nivel.getSeries()){
                log.info("Serie actual es mayor a las series del nivel");
                Integer totalNiveles = this.nivelMapper.getTotalNivelesByIdConcurso(idConcurso);            
                if(nivelActual<= totalNiveles){
                    //Avanza nivel
                    log.info("avanza nivel");
                    jn.setIdConcurso(idConcurso);
                    jn.setdNivel(nivelActual);
                    jn.setSerieActual(Constant.SERIE_UNO);
                    jn.setIdJugador(idJugador);
                    nivel = this.nivelMapper.getNivelByJugadorNivel(jugadorNivel);
                    recompensaGanada = this.ganaPremio(jn,nivel);   
                    this.jugadorNivelMapper.subirNivel(jn);
                }else{
                    //Avanza serie
                    log.info("avanza serie");
                    jn.setIdJugadorNivel(jugadorNivel);
                    jn.setIdConcurso(idConcurso);
                    jn.setdNivel(nivel.getNivel());
                    jn.setSerieActual(ban ? serieActual : serie);
                    jn.setIdJugador(idJugador);
                    this.jugadorNivelMapper.subirSerie(jugadorNivel, serieActual);
                }
            }else{
                //Avanza serie
                log.info("avanza serie");
                jn.setIdJugadorNivel(jugadorNivel);
                jn.setIdConcurso(idConcurso);
                jn.setdNivel(nivel.getNivel());
                jn.setSerieActual(ban ? serieActual : serie);
                jn.setIdJugador(idJugador);
                this.jugadorNivelMapper.subirSerie(jugadorNivel, serieActual);
            }
        }
        jn.setRecompensaGanada(recompensaGanada);
        return jn;
    }
    
    private String ganaPremio(JugadorNivel jugadorNivel, Nivel nivel){
        RecompensaConcursoNivelDTO rcn =  this.jugadorRecompensaMapper.getRecompensaConcurso(nivel.getIdNivel());
        if(objetoValido(rcn)){
            JugadorRecompensa jugadorRecompensa = new JugadorRecompensa();
            jugadorRecompensa.setIdRecompensaConcurso(rcn.getIdRecompensaConcurso());
            jugadorRecompensa.setIdJugador(jugadorNivel.getIdJugador());
            jugadorRecompensa.setCodigo(rcn.getCodigo());
            jugadorRecompensa.setObservacion(rcn.getDescripcion());
            this.jugadorRecompensaMapper.insertJugadorRecompensa(jugadorRecompensa);
        }
        return objetoValido(rcn) ? rcn.getDescripcion() : "";
    }
    
}