/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository.provider;

import com.lafortuna.delsaber.model.RecompensaCodigo;
import org.apache.ibatis.jdbc.SQL;

/**
 *
 * @author cliente
 */
public class RecompensaCodigoProvider {
    
    public static final String recompensa_codigo = "recompensa_codigo";
    
    public String updateRecompensaCodigo(final RecompensaCodigo recompensaCo){
        return new SQL() {{
            UPDATE(recompensa_codigo);
            if ((recompensaCo.getCodigo() != null)){
                SET("codigo = #{codigo}");
            }
            if ((recompensaCo.getActivo() != null)){
                SET("activo = #{activo}");
            }
            if ((recompensaCo.getEstado() != null)){
                SET("estado = #{estado}");
            }
            WHERE("id_recompensa_codigo = #{idRecompensaCodigo}");
        }}.toString();
    }
}
