/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Nivel;
import com.lafortuna.delsaber.repository.provider.NivelProvider;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Cliente
 */
@Mapper
public interface NivelMapper {
    
    @Results(id = "nivel", value = {
        @Result(column = "id_nivel", property = "idNivel", id = true),
        @Result(column = "id_concurso", property = "idConcurso"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "series", property = "series"),
        @Result(column = "tiempo_pregunta", property = "tiempoPregunta"),
        @Result(column = "nivel", property = "nivel")
    })
    @Select("select id_nivel, id_concurso, descripcion, series, tiempo_pregunta, nivel from nivel where id_concurso = #{idConcurso}")
    public List<Nivel> getNivelByIdConcurso(Integer idConcurso);
    
    @Results(id = "nivel_jugador", value = {
        @Result(column = "id_nivel", property = "idNivel", id = true),
        @Result(column = "id_concurso", property = "idConcurso"),
        @Result(column = "descripcion", property = "descripcion"),
        @Result(column = "series", property = "series"),
        @Result(column = "tiempo_pregunta", property = "tiempoPregunta"),
        @Result(column = "nivel", property = "nivel")
    })
 
    @Select("select n.id_nivel, n.id_concurso, n.descripcion, n.series, n.tiempo_pregunta, n.nivel " +
            "from nivel n " +
            "inner join jugador_nivel j on n.id_nivel = j.id_nivel " +
            "where j.id_jugador_nivel = #{idJugadorNivel} limit 1")
    public Nivel getNivelByJugadorNivel(Integer idJugadorNivel);
    
    @Select(
    "select count(*) from nivel where id_concurso = #{idConcurso}"
    )
    public Integer getTotalNivelesByIdConcurso(Integer idConcurso);
    
    @Insert("insert into nivel (id_concurso,descripcion,series,tiempo_pregunta,activo,fecha_registro,nivel)values( "
            +"#{idConcurso}, #{descripcion}, #{series}, #{tiempoPregunta}, #{activo}, #{fechaRegistro}, #{nivel}) ")
	void insertNivel(Nivel nivel) throws DataAccessException;
        
    @UpdateProvider(type = NivelProvider.class, method = "updateNivel")
        void updateNivel(Nivel nivel) throws DataAccessException; 
}
