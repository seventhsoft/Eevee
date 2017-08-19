/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.serie;

import com.lafortuna.delsaber.model.Banner;
import com.lafortuna.delsaber.model.Nivel;
import com.lafortuna.delsaber.model.PorcionSerieDTO;
import com.lafortuna.delsaber.model.Pregunta;
import com.lafortuna.delsaber.repository.BannerMapper;
import com.lafortuna.delsaber.repository.NivelMapper;
import com.lafortuna.delsaber.repository.PreguntaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cliente
 */
@Service
public class SerieServiceImpl extends GenericService implements SerieService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PreguntaMapper preguntaMapper;
    
    @Autowired
    private NivelMapper nivelMapper;
    
    @Autowired
    private BannerMapper bannerMapper;
    
    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getSerieByJugador(Authentication auth, Integer idJugadorNivel) {
        List<PorcionSerieDTO> proporcionPreguntas = this.preguntaMapper.getProporcionPreguntas(getIdJugadorByUser(auth));
        long restantes = computePortion(proporcionPreguntas);    
        List<Pregunta> preguntas = getPreguntas(idJugadorNivel, proporcionPreguntas);
        setPreguntasRestantes(preguntas, restantes);
        setPreguntas(preguntas, idJugadorNivel);

        return getResultMapSerieJugador(preguntas, idJugadorNivel);
    }
    
    public Map<String, Object> getResultMapSerieJugador(List<Pregunta> preguntas, Integer idJugadorNivel) {
        Nivel nivel = this.nivelMapper.getNivelByJugadorNivel(idJugadorNivel);
        setBannerPregunta(preguntas);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("tiempoPregunta", nivel.getTiempoPregunta());
        resultMap.put("bannerSerie", this.bannerMapper.getBannerGrande());
        resultMap.put("preguntas", preguntas);
        return resultMap;
    }
    
    public void setBannerPregunta(List<Pregunta> preguntas) {
        List<Banner> banners = this.bannerMapper.getBannerPequenos();
        if(listaValida(banners)) {
            for(int i = 0; i < banners.size(); i++) {
                preguntas.get(i).setBannerPregunta(banners.get(i).getUrl());
            }
        }        
    }
    
    public void setPreguntasRestantes(List<Pregunta> preguntas, long restantes) {
        if(restantes > 0L) {
            preguntas.addAll(this.preguntaMapper.getPreguntasAleatorias(restantes));
        }
    }
    
    public void setPreguntas(List<Pregunta> preguntas, Integer idJugadorNivel) {
        for(Pregunta pregunta: preguntas) {
            pregunta.setRespuestaList(this.preguntaMapper.getRespuestasPorIdPregunta(pregunta.getIdPregunta(), idJugadorNivel));
        }
    }
    
    public List<Pregunta> getPreguntas(Integer idJugadorNivel, List<PorcionSerieDTO> proporcionPreguntas) {
        List<Pregunta> preguntas = this.preguntaMapper.getPoolPreguntas(Constant.DIFICULTAD_FACIL, idJugadorNivel, proporcionPreguntas.get(0).getPreguntas());
        setPreguntaMensaje(preguntas, idJugadorNivel);
        preguntas.addAll(this.preguntaMapper.getPoolPreguntas(Constant.DIFICULTAD_MEDIA, idJugadorNivel, proporcionPreguntas.get(1).getPreguntas()));
        preguntas.addAll(this.preguntaMapper.getPoolPreguntas(Constant.DIFICULTAD_DIFICIL, idJugadorNivel, proporcionPreguntas.get(2).getPreguntas()));
        return preguntas;
    }
    
    public void setPreguntaMensaje(List<Pregunta> preguntas, Integer idJugadorNivel) {
        Pregunta preguntaMensaje = this.preguntaMapper.getPreguntaMensaje(idJugadorNivel);
        if(objetoValido(preguntaMensaje)) {
            preguntas.set(0, preguntaMensaje);
        }        
    }
    
    public long computePortion(List<PorcionSerieDTO> proporcionPreguntas) {
        long restantes = 0;
        long totalPorcion = getTotalPorcion(proporcionPreguntas);        
        long facil = proporcionPreguntas.get(0).getPreguntas();
        long media = proporcionPreguntas.get(1).getPreguntas();
        long dificl = proporcionPreguntas.get(2).getPreguntas();
        
        if(totalPorcion != Constant.TOTAL_PREGUNTAS_POR_SERIE) {            
            if(totalPorcion < Constant.TOTAL_PREGUNTAS_POR_SERIE) { 
                if(getAvailableQuestions(proporcionPreguntas) < Constant.TOTAL_PREGUNTAS_POR_SERIE) {
                    restantes = getAvailableQuestions(proporcionPreguntas) - Constant.TOTAL_PREGUNTAS_POR_SERIE;
                } else {
                    while(getTotalPorcion(proporcionPreguntas) != Constant.TOTAL_PREGUNTAS_POR_SERIE) {
                       computeLowerPortion(facil, media, dificl, proporcionPreguntas);
                    }
                }
            } else if(totalPorcion > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
                while(getTotalPorcion(proporcionPreguntas) != Constant.TOTAL_PREGUNTAS_POR_SERIE) {
                    computeBiggerPortion(facil, media, dificl, proporcionPreguntas);
                }
            } 
            facil = proporcionPreguntas.get(0).getPreguntas();
            media = proporcionPreguntas.get(1).getPreguntas();
            dificl = proporcionPreguntas.get(2).getPreguntas();
        } 
        computePortionEqual(facil, media, dificl, proporcionPreguntas);
        return restantes;
    }
    
    public void computeLowerPortion(long facil, long media, long dificl, List<PorcionSerieDTO> proporcionPreguntas) {
        Integer dFacil = proporcionPreguntas.get(0).getDisponibles().intValue();
        Integer dMedia = proporcionPreguntas.get(1).getDisponibles().intValue();
        Integer dDificil = proporcionPreguntas.get(2).getDisponibles().intValue();
        
        if(dFacil > dFacil && dFacil > dDificil) {
            proporcionPreguntas.get(0).setPreguntas(dFacil+1);
        }
        if(dMedia > dFacil && dMedia > dDificil) {
            proporcionPreguntas.get(1).setPreguntas(dMedia+1);
        }
        if(dDificil > dFacil && dDificil > dMedia) {
            proporcionPreguntas.get(2).setPreguntas(dDificil+1);
        }
    }
    
    public void computePortionEqual(long facil, long media, long dificl, List<PorcionSerieDTO> proporcionPreguntas) {
        if(media > facil && media > dificl) {
            proporcionPreguntas.get(1).setPreguntas(proporcionPreguntas.get(1).getPreguntas()-1);
            proporcionPreguntas.get(0).setPreguntas(proporcionPreguntas.get(0).getPreguntas()+1);
        }
        if(dificl > facil && dificl > media) {
            proporcionPreguntas.get(2).setPreguntas(proporcionPreguntas.get(2).getPreguntas()-1);
            proporcionPreguntas.get(0).setPreguntas(proporcionPreguntas.get(0).getPreguntas()+1);
        }
    }
    
    public void computeBiggerPortion(long facil, long media, long dificl, List<PorcionSerieDTO> proporcionPreguntas) {
        if(facil > media && facil > dificl && getTotalPorcion(proporcionPreguntas) > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
            proporcionPreguntas.get(0).setPreguntas(proporcionPreguntas.get(0).getPreguntas()-1);
        }
        if(media > facil && media > dificl && getTotalPorcion(proporcionPreguntas) > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
            proporcionPreguntas.get(1).setPreguntas(proporcionPreguntas.get(1).getPreguntas()-1);
        }
        if(dificl > facil && dificl > media && getTotalPorcion(proporcionPreguntas) > Constant.TOTAL_PREGUNTAS_POR_SERIE) {
            proporcionPreguntas.get(2).setPreguntas(proporcionPreguntas.get(2).getPreguntas()-1);
        }
    }
    
    public long getTotalPorcion(List<PorcionSerieDTO> proporcionPreguntas) {
        return proporcionPreguntas.get(0).getPreguntas() + proporcionPreguntas.get(1).getPreguntas() + proporcionPreguntas.get(2).getPreguntas();
    }
    
    public Integer getAvailableQuestions(List<PorcionSerieDTO> proporcionPreguntas) {
        return proporcionPreguntas.get(0).getDisponibles().intValue() + 
                proporcionPreguntas.get(1).getDisponibles().intValue() + 
                proporcionPreguntas.get(2).getDisponibles().intValue();
    }

}
