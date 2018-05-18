/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.concurso;

import com.lafortuna.delsaber.model.ConcursoDTO;
import com.lafortuna.delsaber.model.ConcursoParticipanteDTO;
import com.lafortuna.delsaber.model.Nivel;
import com.lafortuna.delsaber.model.NivelDTO;
import java.util.List;

/**
 *
 * @author cliente
 */
public interface ConcursoService {
    
    List<ConcursoParticipanteDTO> getAllConcurso();
    void insertConcurso(ConcursoDTO concursoDTO);
    void updateConcurso(ConcursoDTO concursoDTO);
    void insertNivel(Nivel nivel);
    void updateNivel(Nivel nivel);
    List<NivelDTO> getNivelesByIdConcurso(Integer idConcurso);
}
