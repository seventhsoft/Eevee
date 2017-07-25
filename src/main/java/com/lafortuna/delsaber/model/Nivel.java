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


public class Nivel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idNivel;
    private String descripcion;
    private Integer series;
    private Integer tiempoPregunta;
    private Boolean activo;
    private Date fechaRegistro;
    private List<JugadorNivel> jugadorNivelList;
    private Concurso concurso;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getTiempoPregunta() {
        return tiempoPregunta;
    }

    public void setTiempoPregunta(Integer tiempoPregunta) {
        this.tiempoPregunta = tiempoPregunta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<JugadorNivel> getJugadorNivelList() {
        return jugadorNivelList;
    }

    public void setJugadorNivelList(List<JugadorNivel> jugadorNivelList) {
        this.jugadorNivelList = jugadorNivelList;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }
}
