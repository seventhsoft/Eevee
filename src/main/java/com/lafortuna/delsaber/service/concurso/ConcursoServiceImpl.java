/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso;

import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.ConcursoParticipanteDTO;
import com.lafortuna.delsaber.repository.ConcursoMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cliente
 */
@Service
public class ConcursoServiceImpl extends GenericService implements ConcursoService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ConcursoMapper concursoMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ConcursoParticipanteDTO> getAllConcurso() {
        List<ConcursoParticipanteDTO> concursoList = this.concursoMapper.getAllConcurso();
        if(listaValida(concursoList)){return concursoList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
}
