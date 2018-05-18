/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.pregunta;

import com.lafortuna.delsaber.model.Pregunta;
import com.lafortuna.delsaber.model.PreguntaMensaje;
import com.lafortuna.delsaber.model.Respuesta;
import com.lafortuna.delsaber.model.RespuestaDTO;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cliente
 */
public interface PreguntaService {
    void cargaPreguntas(MultipartFile file);
    List<PreguntaMensaje>getPreguntaMensajeByPatrocinador(Integer idPatrocinador);
    List<Pregunta> getPreguntaByDificultadDescripcion(Pregunta pregunta);
    List<PreguntaMensaje>getPreguntaMensajeByIdPregunta(Integer idPreguntaMensaje);
    List<Respuesta>getRespuestasByPregunta(Integer idPregunta);
    void updateRespuesta(RespuestaDTO respuestaDTO);
    void insertPreguntaMensaje(PreguntaMensaje preguntaMensaje);
    void updatePreguntaMensaje(PreguntaMensaje preguntaMensaje);
}
