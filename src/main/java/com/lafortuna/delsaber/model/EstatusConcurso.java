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

public class EstatusConcurso implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idEstadoConcurso;
    private String descripcion;
    private boolean activo;
    private Date fechaRegistro;
    private List<Concurso> concursoList;

    public EstatusConcurso() {
    }

    public EstatusConcurso(Integer idEstadoConcurso) {
        this.idEstadoConcurso = idEstadoConcurso;
    }

    public EstatusConcurso(Integer idEstadoConcurso, String descripcion, boolean activo, Date fechaRegistro) {
        this.idEstadoConcurso = idEstadoConcurso;
        this.descripcion = descripcion;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdEstadoConcurso() {
        return idEstadoConcurso;
    }

    public void setIdEstadoConcurso(Integer idEstadoConcurso) {
        this.idEstadoConcurso = idEstadoConcurso;
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

    public List<Concurso> getConcursoList() {
        return concursoList;
    }

    public void setConcursoList(List<Concurso> concursoList) {
        this.concursoList = concursoList;
    }
}
