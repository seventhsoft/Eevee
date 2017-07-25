/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.PatrocinadorPersona;
import com.lafortuna.delsaber.model.Recompensa;
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
public interface AdministracionMapper {
    
    @Results(id = "recompensa", value = {
        @Result(property = "idRecompensa", column = "id_recompensa", id = true), 
        @Result(property = "tipoRecompensa.idTipoRecompensa", column = "id_tipo_recompensa"),
        @Result(property = "patrocinador.idPatrocinador", column = "id_patrocinador"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "cantidad", column = "cantidad", id = true), 
        @Result(property = "vigencia", column = "vigencia"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro")
    })
    @Select("select r.id_recompensa, tr.id_tipo_recompensa, p.id_patrocinador, r.descripcion, r.cantidad, r.vigencia, r.activo, r.fecha_registro  from recompensa r  "
            +"inner join tipo_recompensa tr on r.id_tipo_recompensa = tr.id_tipo_recompensa "
            +"inner join patrocinador p on r.id_patrocinador = p.id_patrocinador "
            + "where r.activo = false ")
    List<Recompensa>getRecompensa();
    
    @Results(id = "patrocinadores", value = {
        @Result(property = "idPersona", column = "id_persona"), 
        @Result(property = "nombre", column = "nombre"),
        @Result(property = "apaterno", column = "apaterno"),
        @Result(property = "amaterno", column = "amaterno"),
        @Result(property = "correo", column = "correo"), 
        @Result(property = "organizacion", column = "organizacion"),
        @Result(property = "idUsuario", column = "id_usuario"),
        @Result(property = "usuario", column = "usuario"),
        @Result(property = "idPatrocinador", column = "id_patrocinador")
    })
    @Select("select  p.id_persona,  p.nombre, p.apaterno, p.amaterno, p.correo, p.organizacion, u.id_usuario, u.usuario, pa.id_patrocinador from patrocinador pa "
            +"inner join persona p on p.id_persona = pa.id_persona "
            +"inner join usuario u on u.id_persona = p.id_persona "
            + "where p.activo = false and u.activo = false ")
    List<PatrocinadorPersona>getPatrocinador();
}
