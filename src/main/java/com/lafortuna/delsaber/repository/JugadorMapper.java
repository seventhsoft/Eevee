/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Cliente
 */
@Mapper
public interface JugadorMapper {
    
    @Select("select id_jugador from jugador where id_persona = #{idPersona}")
    Integer getJugadorByIdPersona(Integer idPersona);
}
