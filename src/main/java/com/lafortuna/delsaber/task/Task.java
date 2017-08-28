/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.task;

import com.lafortuna.delsaber.service.concurso.ActivacionConcursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author andres.ahedo
 */
@Component
public class Task {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    ActivacionConcursoService activacionConcursoService;
    
    //0 45/1 * * * ?
    @Scheduled(cron="0 0 0 1 9/12 ?")
    public void activarConcurso(){
        log.info("se Activa el concurso");
        this.activacionConcursoService.finalizarConcurso();
        this.activacionConcursoService.activarConcurso();
    }
}
