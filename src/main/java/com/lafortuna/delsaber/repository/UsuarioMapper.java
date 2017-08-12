/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.PersonaUsuarioPerfil;
import com.lafortuna.delsaber.model.Usuario;
import com.lafortuna.delsaber.repository.provider.UserProvider;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Cliente
 */
@Mapper
public interface UsuarioMapper {
    
  /*  @Results(id = "personaResult", value = {
        @Result(property = "idPersona", column = "id_persona", id = true),
        @Result(property = "nombre", column = "nombre"),
        @Result(property = "apaterno", column = "apaterno"),
        @Result(property = "amaterno", column = "amaterno"),
        @Result(property = "correo", column = "correo")
    })
    @Select("select id_persona, nombre, apaterno, amaterno, correo from persona where id_persona = #{idPersona} and activo = false")
    Persona getPersonaByIdPersona(String idPersona); */
    
    @Results(id = "userResult", value = {
        @Result(property = "idUsuario", column = "id_usuario", id = true),
        @Result(property = "usuario", column = "usuario"),
        @Result(property = "password", column = "password"),
        @Result(property = "facebook", column = "facebook"),
        @Result(property = "persona.idPersona", column = "id_persona"),
        @Result(property = "persona.nombre", column = "nombre"),
        @Result(property = "persona.apaterno", column = "apaterno"),
        @Result(property = "persona.amaterno", column = "amaterno"),
        @Result(property = "persona.correo", column = "correo")
    })
    @Select("select u.id_usuario, u.usuario, u.password, u.facebook, p.id_persona, p.nombre, p.apaterno, p.amaterno, p.correo from usuario u "
            + "inner join persona p on p.id_persona = u.id_persona "
            + "where u.usuario = #{username} and u.activo = false ")
    Usuario getUsuarioByUserName(String username);
    
    @Results(id = "usuario", value = {
        @Result(property = "idUsuario", column = "id_usuario", id = true), 
        @Result(property = "persona.idPersona", column = "id_persona"),
        @Result(property = "usuario", column = "usuario"),
        @Result(property = "idPerfil", column = "id_perfil"),
        @Result(property = "facebook", column = "facebook"),
        @Result(property = "persona.nombre", column = "nombre"),
        @Result(property = "persona.apaterno", column = "apaterno"),
        @Result(property = "persona.amaterno", column = "amaterno"),
        @Result(property = "persona.correo", column = "correo")
    })
    @Select("select u.id_usuario, pp.id_persona, u.usuario, u.facebook, p.nombre, p.apaterno, p.amaterno, p.correo , pp.id_perfil from usuario u "
            + "inner join persona p on p.id_persona = u.id_persona "
            + "inner join persona_perfil pp on p.id_persona = pp.id_persona "
            + "where u.activo = false ")
    List<Usuario>getUsuarioAll();
    
    @Results(id = "usuarioById", value = {
        @Result(property = "idUsuario", column = "id_usuario", id = true),
        @Result(property = "persona.idPersona", column = "id_persona"),
        @Result(property = "usuario", column = "usuario"),
        @Result(property = "facebook", column = "facebook"),
        @Result(property = "idPerfil", column = "id_perfil"),
        @Result(property = "persona.nombre", column = "nombre"),
        @Result(property = "persona.apaterno", column = "apaterno"),
        @Result(property = "persona.amaterno", column = "amaterno"),
        @Result(property = "persona.correo", column = "correo")
    })
    @Select("select u.id_usuario, pp.id_persona, u.usuario, u.facebook, p.nombre, p.apaterno, p.amaterno, p.correo , pp.id_perfil from usuario u "
            + "inner join persona p on p.id_persona = u.id_persona "
            + "inner join persona_perfil pp on p.id_persona = pp.id_persona "
            + "where u.id_usuario = #{idUsuario} and u.activo = false ")
    Usuario getUsuarioById(Integer idUsuario);
    
    @Select("SELECT CASE WHEN count(*) > 1 THEN true ELSE false END AS BAN FROM persona where correo = #{correo} ")
    Boolean getValidatecorreo(String correo);
    
    @Insert("insert into persona (nombre, apaterno, amaterno, correo) values "
            + "(#{nombre}, #{apaterno}, #{amaterno}, #{correo})")
    @Options(useGeneratedKeys = true, keyColumn = "id_persona", keyProperty = "idPersona")
	void insertPersona(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
        
    @Insert("insert into usuario (id_persona, usuario, password, facebook, activo) values "
            + "(#{idPersona}, #{usuario}, #{password}, #{facebook}, #{activo})")
    @Options(useGeneratedKeys = true, keyColumn = "id_usuario", keyProperty = "idUsuario")
	void insertUsuario(PersonaUsuarioPerfil prsonaUsuarioPerfil) throws DataAccessException;
        
    @Insert("insert into persona_perfil (id_persona, id_perfil) values  "
            + "(#{idPersona}, #{idPerfil}) ")
	void insertPersonaPerfil(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
    
    @Insert("insert into patrocinador(id_persona) values (#{idPersona}) ")
	void insertPatrocinador(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
        
    @Insert("insert into anunciante(id_persona) values (#{idPersona}) ")
	void insertAnunciante(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
        
    @Insert("insert into jugador(id_persona) values (#{idPersona}) ")
	void insertJugador(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
        
    @Delete("delete from persona where id_persona = #{idPersona} ")
        void deletePersona(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
    
    @Delete("delete from usuario where id_usuario = #{idUsuario} ")
        void deleteUsuario(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
        
    @Delete("delete from persona_perfil where id_persona_perfil = #{idPersonaPerfil} and id_persona = #{idPersona}  ")
        void deletePersonaPerfil(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
        
    @UpdateProvider(type = UserProvider.class, method = "updatePersona")
        void updatePersona(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException;
    
    @UpdateProvider(type = UserProvider.class, method = "updateUsuario")           
        void updateUsuario(PersonaUsuarioPerfil personaUsuarioPerfil) throws DataAccessException; 
    
    @Update("update usuario set activo = #{activo} where id_usuario = #{idUsuario} ")
	void updateJugadorActivo(PersonaUsuarioPerfil personaUsuarioPerfil);
    
    @Update("update usuario set password = #{password} where id_usuario = #{idUsuario} ")
	void updateRecuperarPassword(PersonaUsuarioPerfil personaUsuarioPerfil);
}
