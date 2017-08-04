/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Nivel;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Cliente
 */
@Mapper
public interface NivelMapper {
    
    @Results(id = "nivel", value = {
        @Result(column = "id_nivel", property = "idNivel", id = true),
        @Result(column = "id_concurso", property = "idConcurso"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "series", property = "series"),
        @Result(column = "tiempo_pregunta", property = "tiempoPregunta"),
        @Result(column = "nivel", property = "nivel")
    })
    @Select("select id_nivel, id_concurso, descripcion, series, tiempo_pregunta, nivel from nivel where id_concurso = #{idConcurso}")
    public List<Nivel> getNivelByIdConcurso(Integer idConcurso);
}
