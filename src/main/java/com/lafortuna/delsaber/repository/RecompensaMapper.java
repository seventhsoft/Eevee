/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Recompensa;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Andres
 */
@Mapper
public interface RecompensaMapper {

    @Results(id = "recompensaConcurso", value = {
        @Result(column = "id_recompensa", property = "idRecompensa", id=true),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "vigencia", property = "vigencia"),
        @Result(column = "cantidad", property = "cantidad")
    })
    @Select("select r.id_recompensa, r.descripcion, r.vigencia, rc.cantidad "
            + "from recompensa r "
            + "inner join recompensa_concurso rc on r.id_recompensa = rc.id_recompensa "
            + "inner join nivel n on rc.id_nivel = n.id_nivel "
            + "where n.id_concurso = #{idConcurso}")
    List<Recompensa> getRecompensasByConcurso( @Param("idConcurso") Integer idConcurso);

    @Results(id = "recompensaJugador", value = {
        @Result(column = "id_recompensa", property = "idRecompensa", id=true),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "vigencia", property = "vigencia"),
        @Result(column = "cantidad", property = "cantidad"),
        @Result(column = "redimido", property = "redimido")
    })
    @Select("select r.id_recompensa, r.descripcion, r.vigencia, jr.redimido " +
            "from recompensa r " +
            "inner join recompensa_concurso rc on r.id_recompensa = rc.id_recompensa " +
            "inner join nivel n on rc.id_nivel = n.id_nivel " +
            "inner join jugador_recompensa jr on rc.id_recompensa_concurso = jr.id_recompensa_concurso " +
            "where jr.id_jugador = #{idJugador} " +
            "and r.vigencia >= now()")
    List<Recompensa > getRecompensasByJugador(@Param("idJugador") Integer idJugador);
}
