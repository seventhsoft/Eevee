/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.util.Date;

/**
 *
 * @author Cliente
 */
public class ConcursoDTO {
    
    private Integer idConcurso;
    private Integer idEstadoConcurso;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private Boolean activo;
    private Date fechaRegistro;

    /**
     * @return the idConcurso
     */
    public Integer getIdConcurso() {
        return idConcurso;
    }

    /**
     * @param idConcurso the idConcurso to set
     */
    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    /**
     * @return the idEstadoConcurso
     */
    public Integer getIdEstadoConcurso() {
        return idEstadoConcurso;
    }

    /**
     * @param idEstadoConcurso the idEstadoConcurso to set
     */
    public void setIdEstadoConcurso(Integer idEstadoConcurso) {
        this.idEstadoConcurso = idEstadoConcurso;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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
