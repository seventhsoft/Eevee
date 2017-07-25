/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.EstatusConcurso;
import com.lafortuna.delsaber.model.Perfil;
import com.lafortuna.delsaber.model.TipoRecompensa;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author cliente
 */
@Mapper
public interface CatalogosMapper {
    
    @Results(id = "tipoRecompensa", value = {
        @Result(property = "idTipoRecompensa", column = "id_tipo_recompensa", id = true), 
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro")
    })
    @Select("select id_tipo_recompensa, descripcion, activo, fecha_registro from tipo_recompensa  "
            + "where activo = false ")
    List<TipoRecompensa>catalogoTipoRecompensa();
    
    @Results(id = "tipoPerfiles", value = {
        @Result(property = "idPerfil", column = "id_perfil", id = true), 
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "tarjet", column = "tarjet"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro")
    })
    @Select("select id_perfil, descripcion, tarjet, activo, fecha_registro from perfil  "
            + "where activo = false ")
    List<Perfil>catalogoPerfiles();
    
    @Results(id = "estadosConcurso", value = {
        @Result(property = "idEstadoConcurso", column = "id_estado_concurso", id = true), 
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro")
    })
    @Select("select id_estado_concurso, descripcion, activo, fecha_registro from estatus_concurso  "
            + "where activo = false ")
    List<EstatusConcurso>catalogoEstadosConcurso();
}
