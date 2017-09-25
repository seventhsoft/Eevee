/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.patrocinador;

import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.PatrocinadorPersona;
import com.lafortuna.delsaber.repository.PatrocinadorMapper;
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
public class PatrocinadorServiceImpl extends GenericService implements PatrocinadorService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PatrocinadorMapper patrocinadorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PatrocinadorPersona> getAllPatrocinador() {
       List<PatrocinadorPersona> patrocinadorList = this.patrocinadorMapper.getAllPatrocinador();
       if(listaValida(patrocinadorList)) {return patrocinadorList;}
       throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
}
