/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.PatrocinadorPersona;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.repository.AdministracionMapper;
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
public class AdministracionServiceImpl extends GenericService implements AdministracionService{
    
     private final Logger log = LoggerFactory.getLogger(this.getClass());
    
     @Autowired
     private AdministracionMapper administracionMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Recompensa> getRecompensa() {
        List<Recompensa> recompensaList = this.administracionMapper.getRecompensa();
        if(listaValida(recompensaList)) {return recompensaList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatrocinadorPersona> getPatrocinador() {
        List<PatrocinadorPersona> patrocinadoresList = this.administracionMapper.getPatrocinador();
        if(listaValida(patrocinadoresList)){ return patrocinadoresList;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
}
