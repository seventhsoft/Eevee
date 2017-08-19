/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Recompensa;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author cliente
 */
@Mapper
public interface PreguntaRespuestaMapper {

    @Insert("insert into serie (id_jugador_nivel, id_respuesta, serie) values "
            + "(#{idJugadorNivel}, #{idRespuesta}, #{serie})")
    void insertSerie(@Param("idJugadorNivel") Integer idJugadorNivel,
            @Param("idRespuesta") Integer idRespuesta,
            @Param("serie") Integer serie) throws DataAccessException;
    
    @Results(id = "recompensaConcurso", value = {
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "cantidad", column = "cantidad")
    })
    @Select("select r.descripcion, rc.cantidad from recompensa_concurso rc "
            + "inner join jugador_nivel jn on rc.id_nivel = jn.id_nivel "
            + "inner join recompensa r on rc.id_recompensa = r.id_recompensa "
            + "where jn.id_jugador_nivel = #{idJugadorNivel} ")
    Recompensa getRecompensaConcurso(Integer idJugadorNivel);
}
