/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.ConcursoDTO;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author cliente
 */
public class ConcursoProvider {
    
    public static final String concurso = "concurso";
    
    public String updateConcurso(final ConcursoDTO concursoDTO){
        return new SQL() {{
            UPDATE(concurso);
            if ((concursoDTO.getIdEstadoConcurso() != null)){
                SET("id_estado_concurso = #{idEstadoConcurso}");
            }
            if ((concursoDTO.getDescripcion() != null)){
                SET("descripcion = #{descripcion}");
            }
            if ((concursoDTO.getFechaInicio() != null)){
                SET("fecha_inicio = #{fechaInicio}");
            }
            if ((concursoDTO.getFechaFin() != null)){
                SET("fecha_fin = #{fechaFin}");
            }
            if ((concursoDTO.getActivo() != null)){
                SET("activo = #{activo}");
            }
            if ((concursoDTO.getFechaRegistro() != null)){
                SET("fecha_registro = #{fechaRegistro}");
            }
            
            WHERE("id_concurso = #{idConcurso}");
        }}.toString();
    }
}
