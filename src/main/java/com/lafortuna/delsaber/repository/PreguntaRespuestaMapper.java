/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
                            @Param("idRespuesta")Integer idRespuesta,
                            @Param("serie") Integer serie) throws DataAccessException;
}
