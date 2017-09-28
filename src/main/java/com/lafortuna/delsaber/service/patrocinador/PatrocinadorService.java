/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.patrocinador;

import com.lafortuna.delsaber.model.PatrocinadorPersona;
import java.util.List;

/**
 *
 * @author cliente
 */
public interface PatrocinadorService {
    
    List<PatrocinadorPersona> getAllPatrocinador();
    
    void insertPatrocinador(PatrocinadorPersona patrocinadorPersona);
    
    void updatePatrocinador(PatrocinadorPersona patrocinadorPersona);
    
}
