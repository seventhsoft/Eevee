/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.Pregunta;
import com.lafortuna.delsaber.model.PreguntaMensaje;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author cliente
 */
public class PreguntaProvider {
    
    public static final String pregunta = "pregunta";
    public static final String pregunta_mensaje = "pregunta_mensaje";
    
    public String selectPreguntaProvider(final Pregunta preguntaDTO){
        return new SQL() {{
            SELECT("*");
            FROM(pregunta);
            if ((preguntaDTO.getIdDificultad() != null)){
                WHERE("id_dificultad = #{idDificultad}");
            }
            if ((preguntaDTO.getDescripcion() != null)){
                WHERE("descripcion like '%' || #{descripcion} || '%' ");
            }
            WHERE("activo = false");
        }}.toString();
    }
    
    public String updatePreguntaMensaje(final PreguntaMensaje preguntaMensaje){
        return new SQL() {{
            UPDATE(pregunta_mensaje);
            if (( preguntaMensaje.getIdPregunta()!= null)){
                SET("id_pregunta = #{idPregunta}");
            }
            if ((preguntaMensaje.getIdPatrocinador() != null)){
                SET("id_patrocinador = #{idPatrocinador}");
            }
            if ((preguntaMensaje.getIdConcurso() != null)){
                SET("id_concurso = #{idConcurso}");
            }
            if ((preguntaMensaje.getActivo() != null)){
                SET("activo = #{activo}");
            }
            if ((preguntaMensaje.getFechaRegistro() != null)){
                SET("fecha_registro = #{fechaRegistro}");
            }
            WHERE("id_pregunta_mensaje = #{idPreguntaMensaje}");
        }}.toString();
    }
}
