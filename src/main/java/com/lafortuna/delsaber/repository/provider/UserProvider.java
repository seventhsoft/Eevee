/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.PersonaUsuarioPerfil;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author cliente
 */
public class UserProvider {
    
    public static final String persona = "persona";
    public static final String usuario = "usuario";
    
    public String updatePersona(final PersonaUsuarioPerfil personaUsuarioPerfil){
        return new SQL() {{
            UPDATE(persona);
            if ((personaUsuarioPerfil.getNombre() != null)){
                SET("nombre = #{nombre}");
            }
            if ((personaUsuarioPerfil.getApaterno() != null)){
                SET("apaterno = #{apaterno}");
            }
            if ((personaUsuarioPerfil.getAmaterno() != null)){
                SET("amaterno = #{amaterno}");
            }
            if ((personaUsuarioPerfil.getCorreo() != null)){
                SET("correo = #{correo}");
            }
            WHERE("id_persona = #{idPersona}");
        }}.toString();
    }
    
    public String updateUsuario(final PersonaUsuarioPerfil personaUsuarioPerfil){
        return new SQL() {{
            UPDATE(usuario);
            if ((personaUsuarioPerfil.getUsuario() != null)){
                SET("usuario = #{usuario}");
            }
            if ((personaUsuarioPerfil.getPassword() != null)){
                SET("password = #{password}");
            }
            WHERE("id_usuario = #{idUsuario}");
        }}.toString();
    }
}
