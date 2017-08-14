/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.recompensa;

import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.service.GenericService;
import java.util.List;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Andres
 */
public class RecompensaServiceImpl extends GenericService implements RecompensaService{

    @Override
    public List<Recompensa> recompensaByConcurso(Integer idConcurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 

    @Override
    public List<Recompensa> recompensaByJugador(Authentication auth, Integer idConcurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
