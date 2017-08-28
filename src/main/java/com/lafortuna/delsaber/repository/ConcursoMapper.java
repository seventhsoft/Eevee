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
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

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
    @Select("select "
            + "    id_concurso,       "
            + "    c.fecha_inicio,    "
            + "    c.fecha_fin        "
            + "from concurso c        "
            + "inner join estatus_concurso ec on ec.id_estado_concurso = c.id_estado_concurso and ec.id_estado_concurso = 1 "
            + "where c.activo = false")
    Concurso getFechaConcursoActual();

    @Update("update concurso set id_estado_concurso = 1 "
            + "where id_concurso = (select id_concurso from concurso where now() between fecha_inicio "
            + "and fecha_fin and id_estado_concurso = 2 limit 1) ")
    void activarConcurso() throws DataAccessException;;
    
    @Update("update concurso set id_estado_concurso = 4 where id_concurso = (select id_concurso from concurso where now() > fecha_fin and id_estado_concurso = 1 limit 1) ")
    void finalizarConcurso() throws DataAccessException;
}
