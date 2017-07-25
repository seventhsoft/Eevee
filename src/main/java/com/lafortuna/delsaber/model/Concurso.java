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
public class Concurso implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idConcurso;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean activo;
    private Date fechaRegistro;
    private List<RecompensaConcurso> recompensaConcursoList;
    private List<PreguntaMensaje> preguntaMensajeList;
    private EstatusConcurso estatusConcurso;
    private List<Nivel> nivelList;

    public Concurso() {
    }

    public Concurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    public Concurso(Integer idConcurso, String descripcion, Date fechaInicio, Date fechaFin, boolean activo, Date fechaRegistro) {
        this.idConcurso = idConcurso;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdConcurso() {
        return idConcurso;
    }

    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public List<RecompensaConcurso> getRecompensaConcursoList() {
        return recompensaConcursoList;
    }

    public void setRecompensaConcursoList(List<RecompensaConcurso> recompensaConcursoList) {
        this.recompensaConcursoList = recompensaConcursoList;
    }

    public List<PreguntaMensaje> getPreguntaMensajeList() {
        return preguntaMensajeList;
    }

    public void setPreguntaMensajeList(List<PreguntaMensaje> preguntaMensajeList) {
        this.preguntaMensajeList = preguntaMensajeList;
    }

    public EstatusConcurso getEstatusConcurso() {
        return estatusConcurso;
    }

    public void setEstatusConcurso(EstatusConcurso estatusConcurso) {
        this.estatusConcurso = estatusConcurso;
    }

    public List<Nivel> getNivelList() {
        return nivelList;
    }

    public void setNivelList(List<Nivel> nivelList) {
        this.nivelList = nivelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcurso != null ? idConcurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concurso)) {
            return false;
        }
        Concurso other = (Concurso) object;
        if ((this.idConcurso == null && other.idConcurso != null) || (this.idConcurso != null && !this.idConcurso.equals(other.idConcurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lafortuna.delsaber.model.Concurso[ idConcurso=" + idConcurso + " ]";
    }
    
}
