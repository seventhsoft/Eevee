/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.JugadorNivel;
import com.lafortuna.delsaber.model.NivelJugadorDTO;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
public interface JugadorNivelMapper {
    
    @Results(id = "jugadorNivel", value = {
        @Result(column = "id_jugador_nivel", property = "idJugadorNivel"),
        @Result(column = "nivel", property = "dNivel"),
        @Result(column = "serie_actual", property = "serieActual")
    })
    @Select("select " +
            "jn.id_jugador_nivel, " +
            "n.nivel, " +
            "jn.serie_actual from jugador_nivel jn  " +
            "inner join nivel n on n.id_nivel = jn.id_nivel and n.activo = false " +
            "inner join concurso c on c.id_concurso = n.id_concurso and c.activo = false " +
            "inner join estatus_concurso ec on ec.id_estado_concurso = c.id_estado_concurso and ec.id_estado_concurso = 1  " +
            "where jn.id_jugador = #{idJugador}  order by id_jugador_nivel desc limit 1")
    JugadorNivel getJugadorNivelByIdJugador(Integer idJugador);
    
    @Insert("insert into jugador_nivel(id_jugador, id_nivel, serie_actual) values(#{idJugador}, #{idNivel}, #{serieActual})")
    @Options(useGeneratedKeys = true, keyProperty = "idJugadorNivel", keyColumn = "id_jugador_nivel")
    void saveJugadorNivel(JugadorNivel jugadorNivel) throws DataAccessException;
    
    @Results(id = "jugadorNivelDTO", value = {
        @Result(column = "nivel", property = "nivel"),
        @Result(column = "series", property = "series"),
        @Result(column = "seriesjugador", property = "seriesJugador"),
        @Result(column = "tienerecompensa", property = "tieneRecompensa"),
        @Result(column = "recompensasdisponibles", property = "recompensasDisponibles")
    })
    @Select("select " +
                "n.nivel, n.series, " +
                "(select distinct count(serie) from serie s where s.id_jugador_nivel = jn.id_jugador_nivel) seriesJugador, " +
                "(select case when count(*) > 0 then true else false end from jugador_recompensa jr " +
                "inner join recompensa_concurso rc on rc.id_recompensa_concurso = jr.id_recompensa_concurso and rc.id_nivel = n.id_nivel)  tieneRecompensa, " +
                "coalesce((select sum(rc.cantidad - (select count(*) from jugador_recompensa jr2 where jr2.id_recompensa_concurso = rc.id_recompensa_concurso )) " +
                "from recompensa_concurso rc where rc.id_nivel = n.id_nivel),0) recompensasDisponibles " +
            "from nivel n " +
            "inner join concurso c on c.id_concurso = n.id_concurso and c.id_estado_concurso = #{idConcurso} " +
            "left join jugador_nivel jn on jn.id_nivel = n.id_nivel and jn.id_jugador = #{idJugador} " +
            "order by n.nivel")
    List<NivelJugadorDTO> getJugadorNivel(@Param("idConcurso") Integer idConcurso, @Param("idJugador") Integer idJugador);
    
    @Insert("insert into jugador_nivel(id_jugador, id_nivel, serie_actual) values(#{idJugador}, "
            +"(select id_nivel from nivel where id_concurso = #{idConcurso} AND nivel = #{dNivel} )," 
            +"#{serieActual})")
    @Options(useGeneratedKeys = true, keyProperty = "idJugadorNivel", keyColumn = "id_jugador_nivel")
    void subirNivel(JugadorNivel jugadorNivel) throws DataAccessException;
    
    @Update("update jugador_nivel set serie_actual = #{serieActual} where id_jugador_nivel = #{idJugadorNivel}")
    void subirSerie(@Param("idJugadorNivel") Integer idJugadorNivel, @Param("serieActual") Integer serieActual) throws DataAccessException;;
}
