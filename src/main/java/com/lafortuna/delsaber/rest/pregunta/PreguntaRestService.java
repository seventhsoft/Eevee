/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.pregunta;

import com.lafortuna.delsaber.model.Pregunta;
import com.lafortuna.delsaber.model.PreguntaMensaje;
import com.lafortuna.delsaber.model.Respuesta;
import com.lafortuna.delsaber.model.RespuestaDTO;
import com.lafortuna.delsaber.rest.GenericRestService;
import com.lafortuna.delsaber.service.pregunta.PreguntaService;
import java.util.List;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/pregunta")
public class PreguntaRestService {
    
    @Autowired
    private PreguntaService preguntaService;
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/carga", method = RequestMethod.POST)
    public void cargaPreguntas(@RequestParam(value = "file")MultipartFile file) {
        this.preguntaService.cargaPreguntas(file);
    }
    
    @RequestMapping(value = "/mensaje/{idPatrocinador}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PreguntaMensaje> getPreguntaMensajeByPatrocinador(
            @PathVariable("idPatrocinador")Integer idPatrocinador)
    throws NotFoundException{
        return this.preguntaService.getPreguntaMensajeByPatrocinador(idPatrocinador);
    }  
    
    @RequestMapping(value = "/byDificultadDescripcion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getpreguntaBydificultadDescripcion(
            @RequestParam(value="idDificultad",  required = false) Integer idDificultad,
            @RequestParam(value="descripcion",  required = false) String descripcion)
    {
        Pregunta params = new Pregunta();
        params.setIdDificultad(idDificultad);
        params.setDescripcion(descripcion);
        return new ResponseEntity<>(this.preguntaService.getPreguntaByDificultadDescripcion(params), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/preguntaMensaje/{idPreguntaMensaje}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PreguntaMensaje> getPreguntaMensajeByIdPregunta(
            @PathVariable("idPreguntaMensaje")Integer idPreguntaMensaje)
    throws NotFoundException{
        return this.preguntaService.getPreguntaMensajeByIdPregunta(idPreguntaMensaje);
    } 
    
    @RequestMapping(value = "/respuestas/{idPregunta}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Respuesta> getRespuestasByPregunta(
            @PathVariable("idPregunta")Integer idPregunta)
    {
        return this.preguntaService.getRespuestasByPregunta(idPregunta);
    }
    
    @RequestMapping(value = "/respuesta",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void updateRespuesta(@RequestBody RespuestaDTO respuestaDTO){
        this.preguntaService.updateRespuesta(respuestaDTO);
    }
}
