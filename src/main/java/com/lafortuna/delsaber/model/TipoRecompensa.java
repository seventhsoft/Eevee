/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cliente
 */

public class TipoRecompensa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idTipoRecompensa;
    private String descripcion;
    private boolean activo;
    private Date fechaRegistro;
    private List<Recompensa> recompensaList;

    public TipoRecompensa() {
    }

    public TipoRecompensa(Integer idTipoRecompensa) {
        this.idTipoRecompensa = idTipoRecompensa;
    }

    public TipoRecompensa(Integer idTipoRecompensa, String descripcion, boolean activo, Date fechaRegistro) {
        this.idTipoRecompensa = idTipoRecompensa;
        this.descripcion = descripcion;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdTipoRecompensa() {
        return idTipoRecompensa;
    }

    public void setIdTipoRecompensa(Integer idTipoRecompensa) {
        this.idTipoRecompensa = idTipoRecompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<Recompensa> getRecompensaList() {
        return recompensaList;
    }

    public void setRecompensaList(List<Recompensa> recompensaList) {
        this.recompensaList = recompensaList;
    }
}
