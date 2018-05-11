/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.RespuestaDTO;
import org.apache.ibatis.jdbc.SQL;
import static org.apache.ibatis.jdbc.SelectBuilder.WHERE;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;

/**
 *
 * @author cliente
 */
public class RespuestaProvider {
    
    public static final String respuesta = "respuesta";
    
    public String updateRespuesta(final RespuestaDTO respuestaDTO){
        return new SQL() {{
            UPDATE(respuesta);
            if (( respuestaDTO.getIdPregunta()!= null)){
                SET("id_pregunta = #{idPregunta}");
            }
            if ((respuestaDTO.getDescripcion() != null)){
                SET("descripcion = #{descripcion}");
            }
            if ((respuestaDTO.getOrden() != null)){
                SET("orden = #{orden}");
            }
            if ((respuestaDTO.getCorrecta() != null)){
                SET("correcta = #{correcta}");
            }
            if ((respuestaDTO.getActivo() != null)){
                SET("activo = #{activo}");
            }
            if ((respuestaDTO.getFechaRegistro() != null)){
                SET("fecha_registro = #{fechaRegistro}");
            }
            WHERE("id_respuesta = #{idRespuesta}");
        }}.toString();
    }
    
}
