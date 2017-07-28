/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.JugadorNivel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Cliente
 */
@Mapper
public interface JugadorNivelMapper {
    
    @Results(id = "jugadorNivel", value = {
        @Result(column = "nivel", property = "dNivel"),
        @Result(column = "serie_actual", property = "serieActual")
    })
    @Select("select " +
            "n.nivel, " +
            "jn.serie_actual from jugador_nivel jn  " +
            "inner join nivel n on n.id_nivel = jn.id_nivel and n.activo = false " +
            "inner join concurso c on c.id_concurso = n.id_concurso and c.activo = false " +
            "inner join estatus_concurso ec on ec.id_estado_concurso = c.id_estado_concurso and ec.id_estado_concurso = 1  " +
            "where jn.id_jugador = #{idJugador}  order by id_jugador_nivel desc limit 1")
    JugadorNivel getJugadorNivelByIdJugador(Integer idJugador);
    
    @Insert("insert into jugador_nivel(id_juador, id_nivel, serie_actual) values(#{idJugador}, #{idNivel}, #{serieActual})")
    @Options(useGeneratedKeys = true, keyProperty = "idJugadorNivel", keyColumn = "id_jugador_nivel")
    void saveJugadorNivel(JugadorNivel jugadorNivel) throws DataAccessException;
}
