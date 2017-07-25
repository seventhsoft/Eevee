/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.model.PatrocinadorPersona;
import com.lafortuna.delsaber.model.Recompensa;
import java.util.List;

/**
 *
 * @author cliente
 */
public interface AdministracionService {
    
    List<Recompensa>getRecompensa();
    List<PatrocinadorPersona>getPatrocinador();
    
}
