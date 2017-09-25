/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Concurso;
import com.lafortuna.delsaber.model.ConcursoParticipanteDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author Cliente
 */
@Mapper
public interface ConcursoMapper {

    @Results(id = "concursoActual", value = {
        @Result(column = "id_concurso", property = "idConcurso", id = true),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "fecha_inicio", property = "fechaInicio"),
        @Result(column = "fecha_fin", property = "fechaFin")
    })
    @Select("select "
            + "    c.id_concurso,      "
            + "    c.descripcion,     "
            + "    c.fecha_inicio,    "
            + "    c.fecha_fin        "
            + "from concurso c        "
            + "inner join estatus_concurso ec on ec.id_estado_concurso = c.id_estado_concurso and ec.id_estado_concurso = 1 "
            + "where c.activo = false")
    Concurso getFechaConcursoActual();

    @Update("update concurso set id_estado_concurso = 1 "
            + "where id_concurso = (select id_concurso from concurso where now() between fecha_inicio "
            + "and fecha_fin and id_estado_concurso = 2 limit 1) ")
    void activarConcurso();

    @Update("update concurso set id_estado_concurso = 4 where id_concurso = (select id_concurso from concurso where now() > fecha_fin and id_estado_concurso = 1 limit 1) ")
    void finalizarConcurso();

    @Select("select jn.id_jugador "
            + "from jugador_nivel jn "
            + "inner join nivel n on jn.id_nivel = n.id_nivel "
            + "inner join concurso c on n.id_concurso = c.id_concurso "
            + "where "
            + "jn.id_nivel = (select id_nivel from nivel where id_concurso = (select id_concurso from concurso where id_estado_concurso = 1 limit 1) order by nivel desc limit 1) "
            + "AND jn.serie_actual > n.series limit 1")
    Integer getMejorJugador();

    @Results(id = "getAllConcurso", value = {
        @Result(column = "id_concurso", property = "idConcurso"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "fecha_inicio", property = "fechaInicio"),
        @Result(column = "fecha_fin", property = "fechafin"),
        @Result(column = "id_estado_concurso", property = "idEstadoConcurso"),
        @Result(column = "estatus", property = "estatus"),
        @Result(column = "participantes", property = "participantes"),
        @Result(column = "recompensa", property = "recompensa")
    })
    @Select("select "
            + "c.id_concurso, "
            + "c.descripcion, "
            + "c.fecha_inicio, "
            + "c.fecha_fin, "
            + "sc.id_estado_concurso, "
            + "sc.descripcion as estatus, "
            + "sum( rc.cantidad) as recompensa, "
            + "(select count(distinct jn.id_jugador) "
            +"from nivel n inner join jugador_nivel jn on n.id_nivel = jn.id_nivel where n.id_concurso = c.id_concurso) as participantes "
            + "from concurso c "
            + "inner join estatus_concurso sc on c.id_estado_concurso = sc.id_estado_concurso "
            + "left join nivel n on c.id_concurso = n.id_concurso "
            + "left join recompensa_concurso rc on  n.id_nivel =  rc.id_nivel "
            + "group by c.id_concurso,sc.id_estado_concurso "
            + "order by c.id_concurso asc")
    List<ConcursoParticipanteDTO> getAllConcurso();
}
