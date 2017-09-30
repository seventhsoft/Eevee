/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.PatrocinadorPersona;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author cliente
 */
public class PersonaProvider {
    
    public static final String persona = "persona";
    
    public String updatePatrocinador(final PatrocinadorPersona patrocinadorPersona){
        return new SQL() {{
            UPDATE(persona);
            if ((patrocinadorPersona.getNombre() != null)){
                SET("nombre = #{nombre}");
            }
            if ((patrocinadorPersona.getApaterno() != null)){
                SET("apaterno = #{apaterno}");
            }
            if ((patrocinadorPersona.getOrganizacion() != null)){
                SET("organizacion = #{organizacion}");
            }
            if ((patrocinadorPersona.getTelefono() != null)){
                SET("telefono = #{telefono}");
            }
            if ((patrocinadorPersona.getCorreo() != null)){
                SET("correo = #{correo}");
            }
            WHERE("id_persona = #{idPersona}");
        }}.toString();
    }
}
