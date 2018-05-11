/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.PorcionSerieDTO;
import com.lafortuna.delsaber.model.Pregunta;
import com.lafortuna.delsaber.model.PreguntaMensaje;
import com.lafortuna.delsaber.model.Respuesta;
import com.lafortuna.delsaber.model.RespuestaDTO;
import com.lafortuna.delsaber.repository.provider.PreguntaProvider;
import com.lafortuna.delsaber.repository.provider.RespuestaProvider;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Cliente
 */
@Mapper
public interface PreguntaMapper {
   
    @Select("select " +
    "    case when d.id_dificultad = 1 then round(((count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador} " +
    "                                                    where p2.id_dificultad = d.id_dificultad) ) * 6.0) / (select count(*) from pregunta p3 )) " +
    "     when d.id_dificultad = 2 then round(((count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador} " +
    "                                                    where p2.id_dificultad = d.id_dificultad) ) * 6.0) / (select count(*) from pregunta p3 )) " +
    "     when d.id_dificultad = 3 then round(((count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador} " +
    "                                                    where p2.id_dificultad = d.id_dificultad) ) * 6.0) / (select count(*) from pregunta p3 )) " +
    "    end preguntas, "  + 
    "    case when d.id_dificultad = 1 then count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador}   " +
    "                                                    where p2.id_dificultad = d.id_dificultad)  " +
    "     when d.id_dificultad = 2 then count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador}  " +
    "                                                    where p2.id_dificultad = d.id_dificultad) " +
    "     when d.id_dificultad = 3 then count(*) - (select count(*) from pregunta p2 " +
    "                                                        inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                                        inner join serie s on s.id_respuesta = r.id_respuesta " +
    "                                                        inner join jugador_nivel jn on jn.id_jugador_nivel = s.id_jugador_nivel and jn.id_jugador = #{idJugador}  " +
    "                                                    where p2.id_dificultad = d.id_dificultad) " +
    "    end disponibles, d.id_dificultad dificultad " +
    "from pregunta p " +
    "inner join dificultad d on p.id_dificultad = d.id_dificultad  " +
    "group by d.id_dificultad order by d.id_dificultad ")
    @MapKey("dificultad")
    List<PorcionSerieDTO> getProporcionPreguntas(Integer idJugador);
    
    @Results(id = "preguntas", value = {
        @Result(column = "id_pregunta", property = "idPregunta"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "clase", property = "clase"),
        @Result(column = "ruta", property = "ruta")
    })
    @Select("select p.id_pregunta, p.descripcion, p.clase, p.ruta " +
    "from pregunta p " +
    "where p.id_dificultad = #{idDificultad} and  p.activo = false and p.id_pregunta not in ( " +
    "   select distinct p2.id_pregunta " +
    "    from pregunta p2 " +
    "inner join respuesta r2 on r2.id_pregunta = p2.id_pregunta and r2.activo = false " +
    "inner join serie s on s.id_respuesta = r2.id_respuesta and s.id_jugador_nivel = #{idJugadorNivel}   " +
    "where p2.activo = false " +
    ") order by random() limit #{cantidad}")
    List<Pregunta> getPoolPreguntas(@Param("idDificultad") int idDificultad, 
                                    @Param("idJugadorNivel") Integer idJugadorNivel,
                                    @Param("cantidad") long cantidad);
    
    @Results(id = "respuestasPregunta", value = {
        @Result(column = "id_respuesta", property = "idRespuesta"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "correcta", property = "correcta") 
    })
    @Select(" select  r.id_respuesta, r.descripcion, r.correcta " +
    "from respuesta r  " +
    "where r.id_pregunta = #{idPregunta} and r.activo = false and r.id_pregunta not in ( " +
    "   select distinct p2.id_pregunta " +
    "    from pregunta p2 " +
    "inner join respuesta r2 on r2.id_pregunta = p2.id_pregunta and r2.activo = false " +
    "inner join serie s on s.id_respuesta = r2.id_respuesta and s.id_jugador_nivel = #{idJugadorNivel}   " +
    "where p2.activo = false ) order by random() ")
    List<Respuesta> getRespuestasPorIdPregunta(@Param("idPregunta") int idPregunta, 
                                               @Param("idJugadorNivel") Integer idJugadorNivel);
    
        @Results(id = "respuestasPreguntaRestante", value = {
        @Result(column = "id_respuesta", property = "idRespuesta"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "correcta", property = "correcta") 
    })
    @Select(" select  r.id_respuesta, r.descripcion, r.correcta " +
    "from respuesta r  " +
    "where r.id_pregunta = #{idPregunta} and r.activo = false order by random() ")
    List<Respuesta> getRespuestasRestantesPorIdPregunta(@Param("idPregunta") int idPregunta, 
                                               @Param("idJugadorNivel") Integer idJugadorNivel);
    
    @Results(id = "preguntaMensaje", value = {
        @Result(column = "id_pregunta", property = "idPregunta"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "clase", property = "clase"),
        @Result(column = "ruta", property = "ruta")
    })
    @Select("select p.id_pregunta, p.descripcion, p.clase, p.ruta " +
    "from pregunta p " +
    "inner join pregunta_mensaje pm on pm.id_pregunta = p.id_pregunta " +
    "    and pm.id_pregunta not in ( select p2.id_pregunta " +
    "                                from pregunta p2 " +
    "                                inner join pregunta_mensaje pm2 on pm2.id_pregunta = p2.id_pregunta " +
    "                                inner join respuesta r on r.id_pregunta = p2.id_pregunta " +
    "                                inner join serie s on s.id_respuesta = r.id_respuesta and s.id_jugador_nivel = #{idJugadorNivel}) " +
    "where p.activo = false  order by random() limit 1 ")
    Pregunta getPreguntaMensaje( @Param("idJugadorNivel") Integer idJugadorNivel );
    
    @Results(id = "preguntaAleatoria", value = {
        @Result(column = "id_pregunta", property = "idPregunta"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "clase", property = "clase"),
        @Result(column = "ruta", property = "ruta")
    })
    @Select("select p.id_pregunta, p.descripcion, p.clase, p.ruta " +
    "from pregunta p " +
    "where  p.activo = false order by random() limit #{cantidad} ")
    List<Pregunta> getPreguntasAleatorias(@Param("cantidad") long cantidad);
    
    @Insert("insert into pregunta(id_dificultad, descripcion, ruta, clase) values(#{idDificultad}, #{descripcion}, #{ruta}, #{clase})")
    @Options(useGeneratedKeys = true, keyColumn = "id_pregunta", keyProperty = "idPregunta")        
    void guardarPregunta(Pregunta pregunta) throws DataAccessException;
    
    @Insert("insert into respuesta(id_pregunta, descripcion, orden, correcta) values(#{idPregunta}, #{descripcion}, #{orden}, #{correcta})") 
    void guardarRespuesta(Respuesta respuesta) throws DataAccessException;
    
    @Results(id = "preguntaMensajePatrocinador", value = {
        @Result(property = "idPreguntaMensaje", column = "id_pregunta_mensaje", id = true), 
        @Result(property = "pregunta.idPregunta", column = "id_pregunta"),
        @Result(property = "pregunta.descripcion", column = "descripcion"),
        @Result(property = "fechaRegistro", column = "fecha_registro")
    })
    @Select("select pm.id_pregunta_mensaje, p.id_pregunta, p.descripcion, pm.fecha_registro "
            + "from pregunta_mensaje pm "
            + "inner join pregunta p on pm.id_pregunta = p.id_pregunta "
            + "where pm.activo = false "
            +"AND p.activo = false "
            +"AND pm.id_patrocinador = #{idPatrocinador} ")
    List<PreguntaMensaje>getPreguntaMensajeByPatrocinador(Integer idPatrocinador);
    
    @Results(id = "preguntaByDificultadDescripcion", value = {
        @Result(property = "idPregunta",             column = "id_pregunta", id = true),
        @Result(property = "idDificultad",           column = "id_dificultad"),
        @Result(property = "descripcion",            column = "descripcion"),
        @Result(property = "ruta",                   column = "ruta"),
        @Result(property = "clase",                  column = "clase"),
        @Result(property = "activo",                 column = "activo"),
        @Result(property = "fechaRegistro",          column = "fecha_registro")
    })
    @SelectProvider(type = PreguntaProvider.class , method = "selectPreguntaProvider")
    List<Pregunta> getPreguntaByDificultadDescripcion(Pregunta pregunta);
    
    @Results(id = "preguntaMensajeByidPregunta", value = {
        @Result(property = "idPreguntaMensaje",             column = "id_pregunta_mensaje", id = true), 
        @Result(property = "pregunta.idPregunta",           column = "id_pregunta"),
        @Result(property = "patrocinador.idPatrocinador",   column = "id_patrocinador"),
        @Result(property = "concurso.idConcurso",           column = "id_concurso"),
        @Result(property = "activo",                        column = "activo"),
        @Result(property = "fechaRegistro",                 column = "fecha_registro")
    })
    @Select("select id_pregunta_mensaje, id_pregunta, id_patrocinador, id_concurso, activo, fecha_registro "
            + "from pregunta_mensaje "
            + "where id_pregunta_mensaje = #{idPreguntaMensaje} "
            + "and activo = false ")
    List<PreguntaMensaje>getPreguntaMensajeByIdPregunta(Integer idPreguntaMensaje);
    
    @Results(id = "respuestas", value = {
        @Result(property = "idRespuesta",           column = "id_respuesta"), 
        @Result(property = "idPregunta",            column = "id_pregunta"),
        @Result(property = "descripcion",           column = "descripcion"),
        @Result(property = "orden",                 column = "orden"),
        @Result(property = "correcta",              column = "correcta"),
        @Result(property = "activo",                column = "activo"),
        @Result(property = "fechaRegistro",         column = "fecha_registro")
    })
    @Select("select r.id_respuesta,r.id_pregunta,r.descripcion,r.orden,r.correcta,r.activo,r.fecha_registro "
           +"from pregunta p inner join respuesta r on p.id_pregunta = r.id_pregunta "
           +"where p.id_pregunta = #{idPregunta} and p.activo = false")
    List<Respuesta>getRespuestasByPregunta(Integer idPregunta);
    
    @UpdateProvider(type = RespuestaProvider.class, method = "updateRespuesta")
        void updateRespuesta(RespuestaDTO respuestaDTO) throws DataAccessException; 
}
