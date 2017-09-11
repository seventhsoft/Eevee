/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso;

import com.lafortuna.delsaber.repository.ConcursoMapper;
import com.lafortuna.delsaber.service.GenericService;
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
public class ActivacionConcursoServiceImpl extends GenericService implements ActivacionConcursoService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ConcursoMapper concursoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void activarConcurso() {
        try{    
            this.concursoMapper.activarConcurso();
        }catch(Exception e){
            this.log.error(this.getClass().getName() + ":activarConcurso ex:" + e);
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void finalizarConcurso() {
        try{
            this.concursoMapper.finalizarConcurso();
        }catch(Exception e){
            this.log.error(this.getClass().getName() + ":finalizarConcurso ex:" + e);
        }
    }    
}
