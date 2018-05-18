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
 * 
 */
public class NivelDTO {
    
    private Integer idNivel;
    private Integer idConcurso;
    private Integer descripcion;
    private Integer series;
    private Integer tiempoPregunta;
    private Boolean activo;
    private Integer nivel;
    private Date fechaRegistro;

    /**
     * @return the idNivel
     */
    public Integer getIdNivel() {
        return idNivel;
    }

    /**
     * @param idNivel the idNivel to set
     */
    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

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
     * @return the descripcion
     */
    public Integer getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(Integer descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the series
     */
    public Integer getSeries() {
        return series;
    }

    /**
     * @param series the series to set
     */
    public void setSeries(Integer series) {
        this.series = series;
    }

    /**
     * @return the tiempoPregunta
     */
    public Integer getTiempoPregunta() {
        return tiempoPregunta;
    }

    /**
     * @param tiempoPregunta the tiempoPregunta to set
     */
    public void setTiempoPregunta(Integer tiempoPregunta) {
        this.tiempoPregunta = tiempoPregunta;
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
     * @return the nivel
     */
    public Integer getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
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
