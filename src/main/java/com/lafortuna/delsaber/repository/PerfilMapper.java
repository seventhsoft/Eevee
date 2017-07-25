/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Perfil;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Cliente
 */
@Mapper
public interface PerfilMapper {
    
    @Results(id = "perfilResult", value = {
        @Result(property = "idPerfil", column = "id_perfil", id = true),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "tarjet", column = "tarjet")
    })
    @Select("select p.id_perfil, p.descripcion, p.tarjet from persona_perfil pp inner join perfil p on p.id_perfil = pp.id_perfil and p.activo = false where pp.id_persona = #{idPersona} ")
    List<Perfil> getPerfilByIdPersona(Integer idPersona);
}
