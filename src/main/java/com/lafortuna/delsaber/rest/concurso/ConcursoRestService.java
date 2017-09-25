/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.concurso;

import com.lafortuna.delsaber.model.ConcursoParticipanteDTO;
import com.lafortuna.delsaber.service.concurso.ConcursoService;
import java.util.List;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cliente
 */
@RestController
@RequestMapping("/concurso")
public class ConcursoRestService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ConcursoService concursoService;
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ConcursoParticipanteDTO> getAllconcurso() 
    throws NotFoundException{
        return this.concursoService.getAllConcurso();
    }
}
