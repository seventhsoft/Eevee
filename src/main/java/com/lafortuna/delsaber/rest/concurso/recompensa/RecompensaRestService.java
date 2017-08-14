/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.concurso.recompensa;

import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.rest.GenericRestService;
import com.lafortuna.delsaber.service.concurso.recompensa.RecompensaService;
import java.util.List;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author andres.ahedo
 */
@RestController
@RequestMapping("/recompensa")
public class RecompensaRestService extends GenericRestService{
    @Autowired
    private RecompensaService recompensaService;
    
    @RequestMapping(value = "/concurso/{idConcurso}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recompensa> recompensaByConcurso(@PathVariable("idConcurso")Integer idConcurso) throws NotFoundException{
        return this.recompensaService.recompensaByConcurso(idConcurso);
    }
    
    @RequestMapping(value = "/jugador/{idConcurso}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recompensa> recompensaByJugador(@PathVariable("idConcurso")Integer idConcurso, Authentication auth) throws NotFoundException{
        return this.recompensaService.recompensaByJugador(auth,idConcurso);
    }
}
