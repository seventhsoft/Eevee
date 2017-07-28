/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Concurso;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Cliente
 */
@Mapper
public interface ConcursoMapper {
    
    @Results(id = "concursoActual", value = {
        @Result(column = "id_concurso", property = "idConcurso", id = true),
        @Result(column = "fecha_inicio", property = "fechaInicio"),
        @Result(column = "fecha_fin", property = "fechaFin")
    })
    @Select("select " +
            "    id_concurso,       " +
            "    c.fecha_inicio,    " +
            "    c.fecha_fin        " +
            "from concurso c        " +
            "inner join estatus_concurso ec on ec.id_estado_concurso = c.id_estado_concurso and ec.id_estado_concurso = 1 " +
            "where c.activo = false")
    Concurso getFechaConcursoActual();
}
