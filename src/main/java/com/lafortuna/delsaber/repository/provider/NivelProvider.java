/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.Nivel;
import org.apache.ibatis.jdbc.SQL;
import static org.apache.ibatis.jdbc.SelectBuilder.WHERE;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;

/**
 *
 * @author cliente
 */
public class NivelProvider {
    
    public static final String nivel = "nivel";
    
    public String updateNivel(final Nivel nivelDTO){
        return new SQL() {{
            UPDATE(nivel);
            if ((nivelDTO.getIdConcurso() != null)){
                SET("id_concurso = #{idConcurso}");
            }
            if ((nivelDTO.getDescripcion() != null)){
                SET("descripcion = #{descripcion}");
            }
            if ((nivelDTO.getSeries() != null)){
                SET("series = #{series}");
            }
            if ((nivelDTO.getTiempoPregunta() != null)){
                SET("tiempo_pregunta = #{tiempoPregunta}");
            }
            if ((nivelDTO.getActivo() != null)){
                SET("activo = #{activo}");
            }
            if ((nivelDTO.getFechaRegistro() != null)){
                SET("fecha_registro = #{fechaRegistro}");
            }
            if ((nivelDTO.getNivel() != null)){
                SET("nivel = #{nivel}");
            }
            
            WHERE("id_nivel = #{idNivel}");
        }}.toString();
    }
}
