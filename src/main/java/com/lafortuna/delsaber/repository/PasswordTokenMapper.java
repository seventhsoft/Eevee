/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.PasswordToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author nestor.arias
 */
@Mapper
public interface PasswordTokenMapper {
    
    @Insert("insert into password_token (id_usuario,token) "
            + "values(#{idUsuario},#{token})")
    void insertPasswordToken(PasswordToken passwordToken) throws DataAccessException;
    
    @Results(id = "pToken", value = {
        @Result(column = "id_usuario", property = "idUsuario", id = true),
        @Result(column = "token", property = "token"),
        @Result(column = "activo", property = "activo")
    })
    @Select("select id_usuario,token,activo from password_token where id_usuario = #{idUsuario} and activo  = false")
    PasswordToken getPasswordToken(Integer idUsuario);
    
    @Update("update password_token set activo = #{activo} where id_usuario = #{idUsuario} and activo = false")
    void updatePasswordToken(PasswordToken passwordToken) throws DataAccessException;
}
