/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.concurso.recompensa;

import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.model.RecompensaCodigo;
import com.lafortuna.delsaber.rest.GenericRestService;
import com.lafortuna.delsaber.service.concurso.recompensa.RecompensaService;
import java.util.List;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    
    @RequestMapping(value = "/jugador", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recompensa> recompensaByJugador(Authentication auth) throws NotFoundException{
        return this.recompensaService.recompensaByJugador(auth);
    }
    
    @RequestMapping(value = "/patrocinador/{idPatrocinador}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Recompensa> getRecompensasByPatrocinador(
            @PathVariable("idPatrocinador")Integer idPatrocinador)
    throws NotFoundException{
        return this.recompensaService.getRecompensasByPatrocinador(idPatrocinador);
    }  
    
    @RequestMapping(value = "/codigo/{idRecompensa}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecompensaCodigo> getCodigoByRecompensa(
            @PathVariable("idRecompensa")Integer idRecompensa)
    throws NotFoundException{
        return this.recompensaService.getCodigoByRecompensa(idRecompensa);
    }
    
    @RequestMapping(value = "/codigo",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRecompensaCodigo(@RequestBody RecompensaCodigo recompensaCodigo){
        this.recompensaService.saveRecompensaCodigo(recompensaCodigo);
    }
    
    @RequestMapping(value = "/codigo",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUsuarioPersona(@RequestBody RecompensaCodigo RecompensaCo){
        this.recompensaService.updateRecompensaCodigo(RecompensaCo);
    }
}
