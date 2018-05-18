/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso;

import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.ConcursoDTO;
import com.lafortuna.delsaber.model.ConcursoParticipanteDTO;
import com.lafortuna.delsaber.model.Nivel;
import com.lafortuna.delsaber.model.NivelDTO;
import com.lafortuna.delsaber.repository.ConcursoMapper;
import com.lafortuna.delsaber.repository.NivelMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.util.Constant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    
    @Autowired
    private NivelMapper nivelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ConcursoParticipanteDTO> getAllConcurso() {
        List<ConcursoParticipanteDTO> concursoList = this.concursoMapper.getAllConcurso();
        if(listaValida(concursoList)){return concursoList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertConcurso(ConcursoDTO concursoDTO) {
        try{
            this.concursoMapper.insertConcurso(concursoDTO);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + "insertConcurso :" + e);
            throw new InternalServerException("Error al insertar Concurso");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateConcurso(ConcursoDTO concursoDTO) {
       try{
            this.concursoMapper.updateConcurso(concursoDTO);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + "updateConcurso :" + e);
            throw new InternalServerException("Error al modificar Concurso");
        } 
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertNivel(Nivel nivel) {
        try{
            this.nivelMapper.insertNivel(nivel);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + "insertNivel :" + e);
            throw new InternalServerException("Error al insertar Nivel");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNivel(Nivel nivel) {
        try{
            this.nivelMapper.updateNivel(nivel);
        }catch(DataAccessException e){
            this.log.error(this.getClass().getName() + "updateNivel :" + e);
            throw new InternalServerException("Error al modificar Nivel");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<NivelDTO> getNivelesByIdConcurso(Integer idConcurso) {
        List<NivelDTO> nivelList = this.nivelMapper.getNivelesByIdConcurso(idConcurso);
        if(listaValida(nivelList)){ return nivelList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
}
