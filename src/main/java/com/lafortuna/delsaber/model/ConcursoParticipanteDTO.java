/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author nestor.arias
 */
public class ConcursoParticipanteDTO implements Serializable {
    
    private Integer idConcurso;
    private String descripcion;
    private Date fechaInicio;
    private Date fechafin;
    private Integer idEstadoConcurso;
    private String estatus;
    private Integer participantes;
    private Integer recompensa;

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
     * @return the fechafin
     */
    public Date getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
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
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the participantes
     */
    public Integer getParticipantes() {
        return participantes;
    }

    /**
     * @param participantes the participantes to set
     */
    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    /**
     * @return the recompensa
     */
    public Integer getRecompensa() {
        return recompensa;
    }

    /**
     * @param recompensa the recompensa to set
     */
    public void setRecompensa(Integer recompensa) {
        this.recompensa = recompensa;
    }
}
