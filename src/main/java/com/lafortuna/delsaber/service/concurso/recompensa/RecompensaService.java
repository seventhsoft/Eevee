/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso.recompensa;

import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.model.RecompensaCodigo;
import java.util.List;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Andres
 */
public interface RecompensaService {
    
    List<Recompensa> recompensaByConcurso(Integer idConcurso);
    List<Recompensa> recompensaByJugador(Authentication auth);
    void premioMayor();
    List<Recompensa> getRecompensasByPatrocinador(Integer idPatrocinador);
    List<RecompensaCodigo> getCodigoByRecompensa(Integer idRecompensa);
}
