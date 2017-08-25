/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.concurso;

/**
 *
 * @author cliente
 */
public interface ActivacionConcursoService {
    
    void activarConcurso(Integer idConcurso);
    
    void finalizarConcurso(Integer idConcurso);
}
