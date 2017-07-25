/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.model.EstatusConcurso;
import com.lafortuna.delsaber.model.Perfil;
import com.lafortuna.delsaber.model.TipoRecompensa;
import java.util.List;

/**
 *
 * @author cliente
 */
public interface CatalogosService {
    
    List<TipoRecompensa>catalogoTipoRecompensa();
    List<Perfil>catalogoPerfiles();
    List<EstatusConcurso>catalogoEstadosConcurso();
    
}
