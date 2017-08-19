/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.repository.PreguntaRespuestaMapper;
import com.lafortuna.delsaber.service.GenericService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

    @Override
    public Recompensa insertSerie(Map<String, Integer> map) {
        Integer jugadorNivel = map.get("idJugadorNivel");
        Integer respuesta = map.get("idRespuesta");
        Integer serie = map.get("serie");
        Recompensa recompensa = new Recompensa();
        try{
            this.preguntaRespuestaMapper.insertSerie(jugadorNivel, respuesta, serie);
            recompensa = this.preguntaRespuestaMapper.getRecompensaConcurso(jugadorNivel);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + ":insertSerie ex:" + e);
            throw new InternalServerException("Error al guardar serie: "+e);
        }
        return recompensa;
    }
    
}
