/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.pregunta;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cliente
 */
public interface PreguntaService {
    void cargaPreguntas(MultipartFile file);
    
}
