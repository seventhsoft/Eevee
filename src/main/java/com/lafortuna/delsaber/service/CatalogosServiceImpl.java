/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.EstatusConcurso;
import com.lafortuna.delsaber.model.Perfil;
import com.lafortuna.delsaber.model.TipoRecompensa;
import com.lafortuna.delsaber.repository.CatalogosMapper;
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
public class CatalogosServiceImpl extends GenericService implements CatalogosService {
    
     private final Logger log = LoggerFactory.getLogger(this.getClass());
     
     @Autowired 
     private CatalogosMapper catalogosMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TipoRecompensa> catalogoTipoRecompensa() {
       List<TipoRecompensa> tipoRecompensaList = this.catalogosMapper.catalogoTipoRecompensa();
       if(listaValida(tipoRecompensaList)) {return tipoRecompensaList;}
       throw new NoContentException(Constant.NO_CONTENT_MESSAGE); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<Perfil> catalogoPerfiles() {
        List<Perfil> perfilesList = this.catalogosMapper.catalogoPerfiles();
        if(listaValida(perfilesList)){ return perfilesList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EstatusConcurso> catalogoEstadosConcurso() {
        List<EstatusConcurso> estadoConcursoList = this.catalogosMapper.catalogoEstadosConcurso();
        if(listaValida(estadoConcursoList)) { return estadoConcursoList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
}
