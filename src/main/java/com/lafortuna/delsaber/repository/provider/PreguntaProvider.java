/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.Pregunta;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author cliente
 */
public class PreguntaProvider {
    
    public static final String pregunta = "pregunta";
    
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
}
