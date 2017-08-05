/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.concurso.serie;

import com.lafortuna.delsaber.concurso.serie.PreguntaRespuestaService;
import com.lafortuna.delsaber.service.GenericService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cliente
 */
@RestController
@RequestMapping("/serie")
public class PreguntaRespuestaRestService extends GenericService {
    
    @Autowired
    private PreguntaRespuestaService preguntaRespuestaService;
    
    @RequestMapping(value = "/preguntarespuesta", method = RequestMethod.POST)
    public Map<String, String>insertSerie(@RequestBody Map<String, Integer> map){
        
        Map<String,String> result = new HashMap<>();
        result.put("msg", "ok");
        this.preguntaRespuestaService.insertSerie(map);
        return result;
    }
    
}
