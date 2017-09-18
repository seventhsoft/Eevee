/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.pregunta;

import com.lafortuna.delsaber.service.pregunta.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/pregunta")
public class PreguntaRestService {
    
    @Autowired
    private PreguntaService preguntaService;
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/carga", method = RequestMethod.POST)
    public void cargaPreguntas(@RequestParam(value = "file")MultipartFile file) {
        this.preguntaService.cargaPreguntas(file);
    }
    
}
