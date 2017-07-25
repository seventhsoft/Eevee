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

public class Recompensa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idRecompensa;
    private String descripcion;
    private int cantidad;
    private Date vigencia;
    private boolean activo;
    private Date fechaRegistro;
    private Patrocinador patrocinador;
    private TipoRecompensa tipoRecompensa;
    private List<RecompensaConcurso> recompensaConcursoList;

    public Recompensa() {
    }

    public Recompensa(Integer idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public Recompensa(Integer idRecompensa, String descripcion, int cantidad, Date vigencia, boolean activo, Date fechaRegistro) {
        this.idRecompensa = idRecompensa;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.vigencia = vigencia;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(Integer idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
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

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public TipoRecompensa getTipoRecompensa() {
        return tipoRecompensa;
    }

    public void setTipoRecompensa(TipoRecompensa tipoRecompensa) {
        this.tipoRecompensa = tipoRecompensa;
    }

    public List<RecompensaConcurso> getRecompensaConcursoList() {
        return recompensaConcursoList;
    }

    public void setRecompensaConcursoList(List<RecompensaConcurso> recompensaConcursoList) {
        this.recompensaConcursoList = recompensaConcursoList;
    }
}
