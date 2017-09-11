/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Recompensa;
import com.lafortuna.delsaber.model.RecompensaConcursoNivelDTO;
import com.lafortuna.delsaber.util.Constant;
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
        @Result(column = "cantidad", property = "cantidad"),
        @Result(column = "organizacion", property = "organizacion")
    })
    @Select("select r.id_recompensa, r.descripcion, r.vigencia, rc.cantidad, per.organizacion "
            + "from recompensa r "
            + "inner join recompensa_concurso rc on r.id_recompensa = rc.id_recompensa "
            + "inner join nivel n on rc.id_nivel = n.id_nivel "
            +"inner join patrocinador p on r.id_patrocinador = p.id_patrocinador "
            +"inner join persona per on p.id_persona = per.id_persona "
            + "where n.id_concurso = #{idConcurso}")
    List<Recompensa> getRecompensasByConcurso( @Param("idConcurso") Integer idConcurso);

    @Results(id = "recompensaJugador", value = {
        @Result(column = "id_recompensa", property = "idRecompensa", id=true),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "vigencia", property = "vigencia"),
        @Result(column = "cantidad", property = "cantidad"),
        @Result(column = "redimido", property = "redimido"),
        @Result(column = "codigo", property = "codigo"),
        @Result(column = "organizacion", property = "organizacion")
    })
    @Select("select r.id_recompensa, r.descripcion, r.vigencia, jr.redimido , rco.codigo, per.organizacion "
            +"from recompensa r "
            +"inner join recompensa_codigo rco on r.id_recompensa = rco.id_recompensa "
            +"inner join recompensa_concurso rc on r.id_recompensa = rc.id_recompensa "
            +"inner join nivel n on rc.id_nivel = n.id_nivel "
            +"inner join jugador_recompensa jr on rc.id_recompensa_concurso = jr.id_recompensa_concurso "
            +"inner join patrocinador p on r.id_patrocinador = p.id_patrocinador "
            +"inner join persona per on p.id_persona = per.id_persona "
            +"where jr.id_jugador = #{idJugador} "
            +"and r.vigencia >= now()")
    List<Recompensa > getRecompensasByJugador(@Param("idJugador") Integer idJugador);

    
    @Results(id = "getPremioMayor", value = {
        @Result(column = "id_recompensa_concurso", property = "idRecompensaConcurso", id=true),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "codigo", property = "codigo"),
        @Result(column = "vigencia", property = "vigencia")
    })
    @Select("select r.descripcion, rc.id_recompensa_concurso, rco.codigo, r.vigencia " +
            "from recompensa_concurso rc " +
            "inner join recompensa r on rc.id_recompensa = r.id_recompensa " +
            "inner join tipo_recompensa tr on r.id_tipo_recompensa = tr.id_tipo_recompensa " +
            "inner join recompensa_codigo rco on r.id_recompensa = rco.id_recompensa  " +
            "where r.activo = false " +
            "and tr.id_tipo_recompensa = "+ Constant.TIPO_RECOMPENSA_MAYOR +" " +
            "and rc.id_nivel = (select id_nivel from nivel where id_concurso = (select id_concurso from concurso where id_estado_concurso = 1 limit 1) order by nivel desc limit 1) " +
            "and rc.cantidad > (select count(*) from jugador_recompensa where id_recompensa_concurso = rc.id_recompensa_concurso)")
    RecompensaConcursoNivelDTO getPremioMayor();
}
