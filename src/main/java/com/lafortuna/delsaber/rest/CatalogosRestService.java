/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest;

import com.lafortuna.delsaber.model.EstatusConcurso;
import com.lafortuna.delsaber.model.Perfil;
import com.lafortuna.delsaber.model.TipoRecompensa;
import com.lafortuna.delsaber.service.CatalogosService;
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
@RequestMapping("/catalogos")
public class CatalogosRestService {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private CatalogosService catalogosService;
    
    @RequestMapping(value = "/tiposrecompensa",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoRecompensa> catalogoTipoRecompensa()
    throws NotFoundException{
        return this.catalogosService.catalogoTipoRecompensa();
    }
    
    @RequestMapping(value = "perfiles",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Perfil> catalogoPerfiles()
    throws NotFoundException{
        return this.catalogosService.catalogoPerfiles();
    }
    
    @RequestMapping(value = "estadosConcurso",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EstatusConcurso> catalogoEstadosConcurso()
    throws NotFoundException{
        return this.catalogosService.catalogoEstadosConcurso();
    }
}
