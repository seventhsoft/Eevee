/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import com.lafortuna.delsaber.util.Constant;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cliente
 */

public class Banner implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idBanner;
    private String descripcion;
    private Integer impresiones;
    private Integer interacciones;
    private String ruta;
    private boolean activo;
    private boolean tipo;
    private Integer idCampana;
    private Date fechaRegistro;
    private Campana campana;
    private String url;

    public Banner() {
    }

    public Banner(Integer idBanner) {
        this.idBanner = idBanner;
    }

    public Banner(Integer idBanner, String descripcion, String ruta, boolean activo, Date fechaRegistro, boolean tipo, Integer idCampana, String url) {
        this.idBanner = idBanner;
        this.descripcion = descripcion;
        this.ruta = ruta;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.tipo = tipo;
        this.idCampana = idCampana;
        this.url = url;
    }
    
    public Integer getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(Integer idBanner) {
        this.setUrl(Constant.BANNER_INTERACION + "/" + idBanner.toString());
        this.idBanner = idBanner;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getImpresiones() {
        return impresiones;
    }

    public void setImpresiones(Integer impresiones) {
        this.impresiones = impresiones;
    }

    public Integer getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(Integer interacciones) {
        this.interacciones = interacciones;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Campana getCampana() {
        return campana;
    }

    public void setCampana(Campana campana) {
        this.campana = campana;
    }
    
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setIdCampana(Integer idCampana) {
        this.idCampana = idCampana;
    }

    public Integer getIdCampana() {
        return idCampana;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
        
}
