/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.util.Date;

/**
 *
 * @author cliente
 */
public class RecompensaCodigo {
    
    private Integer idRecompensa;
    private String codigo;
    private Boolean activo;
    private Date fechaRegistro;

    /**
     * @return the idRecompensa
     */
    public Integer getIdRecompensa() {
        return idRecompensa;
    }

    /**
     * @param idRecompensa the idRecompensa to set
     */
    public void setIdRecompensa(Integer idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
