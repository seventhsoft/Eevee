/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.recompensa;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.Concurso;
import com.lafortuna.delsaber.model.JugadorRecompensa;
import com.lafortuna.delsaber.model.Persona;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.model.RecompensaCodigo;
import com.lafortuna.delsaber.model.RecompensaConcursoNivelDTO;
import com.lafortuna.delsaber.repository.ConcursoMapper;
import com.lafortuna.delsaber.repository.JugadorRecompensaMapper;
import com.lafortuna.delsaber.repository.RecompensaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.service.MailService;
import com.lafortuna.delsaber.util.Constant;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andres
 */
@Service
public class RecompensaServiceImpl extends GenericService implements RecompensaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecompensaMapper recompensaMapper;
    
    @Autowired
    private ConcursoMapper concursoMapper;

    @Autowired
    private JugadorRecompensaMapper jugadorRecompensaMapper;
    
    @Autowired 
    private MailService mailService;
    
    @Override
    public List<Recompensa> recompensaByConcurso(Integer idConcurso) {
        List<Recompensa> lista = this.recompensaMapper.getRecompensasByConcurso(idConcurso);
        if (objetoValido(lista)) {
            return lista;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public List<Recompensa> recompensaByJugador(Authentication auth) {
        Integer idJugador = getIdJugadorByUser(auth);
        log.debug("idJugador:" + idJugador);
        List<Recompensa> lista =  this.recompensaMapper.getRecompensasByJugador(idJugador);
        if (objetoValido(lista)) {
            return lista;
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    public void premioMayor() {
        Integer idJugador = this.concursoMapper.getMejorJugador();
        RecompensaConcursoNivelDTO recompensa = this.recompensaMapper.getPremioMayor();
        if(objetoValido(idJugador) && objetoValido(recompensa)){
            /* Alguien gano */
            JugadorRecompensa jr = new JugadorRecompensa();
            jr.setIdRecompensaConcurso(recompensa.getIdRecompensaConcurso());
            jr.setIdJugador(idJugador);
            jr.setCodigo(recompensa.getCodigo());
            jr.setObservacion(recompensa.getDescripcion());
            this.jugadorRecompensaMapper.insertJugadorRecompensa(jr);
            Concurso concurso = this.concursoMapper.getFechaConcursoActual();
            Persona p = this.jugadorRecompensaMapper.getPersonaByIdJugador(idJugador);
            if(objetoValido(concurso)){
                Format formatter = new SimpleDateFormat("dd-MM-yyyy");
                String vigencia = formatter.format(recompensa.getVigencia());
                Map<String,String> parametros = new HashMap<>();
                parametros.put("concurso", concurso.getDescripcion());
                parametros.put("recompensa", recompensa.getDescripcion());
                parametros.put("vigencia", vigencia);
                parametros.put("nombre", p.getNombre() + " " +p.getApaterno());
                this.mailService.enviaCorreoPremioMayor(p.getCorreo(), parametros);
            }
        }else if(objetoValido(recompensa)){
            /* no gana */
            
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Recompensa> getRecompensasByPatrocinador(Integer idPatrocinador) {
        List<Recompensa> recompensaList = this.recompensaMapper.getRecompensasByPatrocinador(idPatrocinador);
        if(listaValida(recompensaList)) {return recompensaList;}	
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecompensaCodigo> getCodigoByRecompensa(Integer idRecompensa) {
        List<RecompensaCodigo> codigoList = this.recompensaMapper.getCodigoByRecompensa(idRecompensa);
	if(listaValida(codigoList)) {return codigoList;}
	throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRecompensaCodigo(RecompensaCodigo recompensaCodigo) {
        try{
            this.recompensaMapper.saveRecompensaCodigo(recompensaCodigo);
        }catch(DataAccessException e){
            log.error(this.getClass().getName() + "saveRecompensaCodigo" + e);
            throw new InternalServerException(": Error al insertar recompensa codigo");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRecompensaCodigo(RecompensaCodigo recompensaCo) {
        try{
            this.recompensaMapper.updateRecompensaCodigo(recompensaCo);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + ":updateJugadorActivo ex:" + e);
            throw new InternalServerException(": Error al modificar recompensa codigo");
        }    
    }
}
