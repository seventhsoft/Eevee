/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.repository;

import com.lafortuna.delsaber.model.Banner;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author Andres
 */
@Mapper
public interface BannerMapper {

    @Results(id = "bannerPequenos", value = {
        @Result(property = "idBanner", column = "id_banner", id = true),
        @Result(property = "idCampana", column = "id_campana"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "impresiones", column = "impresiones"),
        @Result(property = "interacciones", column = "interacciones"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro"),
        @Result(property = "ruta", column = "ruta")
    })
    @Select(
            "select  b.id_banner,  "
            + "	b.id_campana,  "
            + "	b.descripcion,  "
            + "	b.impresiones,  "
            + "	b.interacciones,  "
            + "	b.tipo,  "
            + "	b.activo,  "
            + "	b.fecha_registro,  "
            + "	b.ruta  "        
            + "from banner b  "
            + "inner join campana c on c.id_campana = b.id_campana and c.activo = false AND now() between c.fecha_inicio and c.fecha_fin   "
            + "where b.tipo = false  "
            + "order by random() limit 6"
    )
    List<Banner> getBannerPequenos();

    @Results(id = "bannerGrande", value = {
        @Result(property = "idBanner", column = "id_banner", id = true),
        @Result(property = "idCampana", column = "id_campana"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "impresiones", column = "impresiones"),
        @Result(property = "interacciones", column = "interacciones"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro"),
        @Result(property = "ruta", column = "ruta")
    })
    @Select("select  b.id_banner,  "
            + "	b.id_campana,  "
            + "	b.descripcion,  "
            + "	b.impresiones,  "
            + "	b.interacciones,  "
            + "	b.tipo,  "
            + "	b.activo,  "
            + "	b.fecha_registro,  "
            + "	b.ruta  "
            + "from banner b  "
            + "inner join campana c on c.id_campana = b.id_campana and c.activo = false AND now() between c.fecha_inicio and c.fecha_fin   "
            + "where b.tipo = false  "
            + "order by random() limit 1"
    )
    Banner getBannerGrande();
    
    @Results(id = "banner", value = {
        @Result(property = "idBanner", column = "id_banner", id = true),
        @Result(property = "idCampana", column = "id_campana"),
        @Result(property = "descripcion", column = "descripcion"),
        @Result(property = "impresiones", column = "impresiones"),
        @Result(property = "interacciones", column = "interacciones"),
        @Result(property = "ruta", column = "ruta"),
        @Result(property = "activo", column = "activo"),
        @Result(property = "fechaRegistro", column = "fecha_registro")
    })
    @Select("select  id_banner,  "
            + "	id_campana,  "
            + "	descripcion,  "
            + "	impresiones,  "
            + "	interacciones,  "
            + "	tipo,  "
            + "	ruta,  "
            + "	activo,  "
            + "	fecha_registro,  "
            + "	ruta  "
            + "from banner  "
            + "where id_banner = #{idBanner}"
    )
    Banner getBannerById(Integer idBanner);
    
    @Insert("insert into banner(id_banner, id_campana,descripcion,impresiones,interacciones,ruta,tipo) " +
            "values(#{idBanner},#{idCampana},#{descripcion},#{impresiones},#{interacciones},#{ruta},#{tipo});")
    @Options(useGeneratedKeys = true, keyColumn = "id_banner", keyProperty = "idBanner")
    void insertBanner(Banner banner) throws DataAccessException;
    
    @Update("update banner set impresiones = impresiones+1 where id_banner = #{idBanner};")
    void updateAgregaImpresionBanner(Banner banner) throws  DataAccessException;
    
    @Update("update banner set interacciones = interacciones+1 where id_banner = #{idBanner};")
    void updateAgregaInteraccionBanner(Integer idBanner) throws  DataAccessException;
    
}
