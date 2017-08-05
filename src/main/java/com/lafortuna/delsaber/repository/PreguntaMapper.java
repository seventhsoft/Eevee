/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Cliente
 */
@Mapper
public interface PreguntaMapper {
    
    @Select("select " +
    "    case when d.id_dificultad = 1 then floor(((count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador} " +
    "                                                    where p2.id_dificultad = d.id_dificultad) ) * 6.0) / (select count(*) from pregunta p3 )) " +
    "     when d.id_dificultad = 2 then floor(((count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador} " +
    "                                                    where p2.id_dificultad = d.id_dificultad) ) * 6.0) / (select count(*) from pregunta p3 )) " +
    "     when d.id_dificultad = 3 then floor(((count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador} " +
    "                                                    where p2.id_dificultad = d.id_dificultad) ) * 6.0) / (select count(*) from pregunta p3 )) " +
    "    end preguntas, d.id_dificultad dificultad " +
    "from pregunta p " +
    "inner join dificultad d on p.id_dificultad = d.id_dificultad  " +
    "group by d.id_dificultad order by d.id_dificultad ")
    @MapKey("dificultad")
    public Map<Integer, Map<String, Integer>> getProporcionPreguntas(Integer idJugador);
}
