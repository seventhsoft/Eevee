/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest;

import com.lafortuna.delsaber.model.PatrocinadorPersona;
import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.service.AdministracionService;
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
@RequestMapping("/administracion")
public class AdministracionRestService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private AdministracionService administracionService;
    
    @RequestMapping(value = "/recompensas",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recompensa>getRecompensa()
    throws NotFoundException{
        return this.administracionService.getRecompensa();
    }
    
    @RequestMapping(value = "/patrocinadores",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PatrocinadorPersona>getPatrocinador()
    throws NotFoundException{
        return this.administracionService.getPatrocinador();
    }
    
}
