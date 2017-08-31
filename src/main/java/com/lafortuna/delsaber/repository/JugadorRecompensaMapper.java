/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.JugadorRecompensa;
import com.lafortuna.delsaber.model.Persona;
import com.lafortuna.delsaber.model.RecompensaConcursoNivelDTO;
import com.lafortuna.delsaber.util.Constant;
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
public interface JugadorRecompensaMapper {
    
    @Results(id = "getRecompensaConcurso", value = {
        @Result(column = "id_recompensa_concurso", property = "idRecompensaConcurso", id=true),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "codigo", property = "codigo")
    })
    @Select("select case when (select rc.cantidad - (select count(*) from jugador_recompensa jr2 where jr2.id_recompensa_concurso = rc.id_recompensa_concurso ) " +
            "from recompensa_concurso rc where rc.id_nivel = #{idNivel} limit 1) = 0 then '' else r.descripcion end, " +
            "rc.id_recompensa_concurso, rco.codigo " +
            "from recompensa_concurso rc " +
            "inner join recompensa r on rc.id_recompensa = r.id_recompensa " +
            "inner join recompensa_codigo rco on r.id_recompensa = rco.id_recompensa " +
            "where rc.id_nivel = #{idNivel} " +
            "AND r.id_tipo_recompensa = "+ Constant.TIPO_RECOMPENSA_NIVEL + " limit 1")
    RecompensaConcursoNivelDTO getRecompensaConcurso(@Param("idNivel") Integer idNivel);
    
    @Insert("insert into jugador_recompensa (id_recompensa_concurso, id_jugador, codigo, observacion, redimido ) values "
            + "(#{idRecompensaConcurso}, #{idJugador}, #{codigo}, #{observacion}, false) ")
	void insertJugadorRecompensa(JugadorRecompensa jugadorRecompensa) throws DataAccessException;

    @Results(id = "getPersonaByIdJugador", value = {
        @Result(column = "id_persona", property = "idPersona", id=true),
        @Result(column = "nombre", property = "nombre"),
        @Result(column = "apaterno", property = "apaterno"),
        @Result(column = "correo", property = "correo")
    })
    @Select("select p.id_persona, p.nombre, p.apaterno , p.correo " +
            "from persona p " +
            "inner join jugador j on j.id_persona = p.id_persona " +
            "where j.id_jugador = #{idJugador}")
    Persona getPersonaByIdJugador(Integer idJugador);
    
}
