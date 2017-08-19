/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.recompensa;

import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.repository.RecompensaMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class RecompensaServiceImpl extends GenericService implements RecompensaService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RecompensaMapper recompensaMapper;

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

}
