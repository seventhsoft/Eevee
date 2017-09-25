/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.PatrocinadorPersona;
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
public interface PatrocinadorMapper {
    
    @Results(id = "getAllPatrocinador", value = {
        @Result(column = "id_patrocinador", property = "idPatrocinador"),
        @Result(column = "id_persona", property = "idPersona"),
        @Result(column = "nombre", property = "nombre"),
        @Result(column = "apaterno", property = "apaterno"),
        @Result(column = "organizacion", property = "organizacion"),
        @Result(column = "telefono", property = "telefono"),
        @Result(column = "correo", property = "correo"),
        @Result(column = "activo", property = "activo"),
        @Result(column = "fecha_registro", property = "fechaRegistro"),
        @Result(column = "recompensa", property = "totalRecompensas"),
        @Result(column = "pregunta", property = "totalPreguntasMensaje")
    })
    @Select("select "
            + "p.id_patrocinador, "
            + "p.id_persona, "
            + "pe.nombre, "
            + "pe.apaterno, "
            + "pe.organizacion, "
            + "pe.telefono, "
            + "pe.correo, "
            + "pe.activo, "
            + "pe.fecha_registro, "
            + "count( r.cantidad) as recompensa, "
            + "(select count(id_pregunta) from pregunta_mensaje where id_patrocinador = p.id_patrocinador) as pregunta "
            + "from patrocinador p "
            + "inner join persona pe on p.id_persona = pe.id_persona "
            + "inner join recompensa r on p.id_patrocinador = r.id_patrocinador "
            + "where pe.activo = false "
            +"group by p.id_patrocinador,pe.nombre,pe.apaterno, pe.organizacion,pe.telefono,pe.correo,pe.activo,pe.fecha_registro "
            +"order by p.id_patrocinador asc")
    List<PatrocinadorPersona> getAllPatrocinador();
}
