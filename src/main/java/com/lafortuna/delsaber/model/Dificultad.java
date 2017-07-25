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

public class Dificultad implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idDificultad;
    private String descripcion;
    private boolean activo;
    private Date fechaRegistro;
    private List<Pregunta> preguntaList;

    public Dificultad() {
    }

    public Dificultad(Integer idDificultad) {
        this.idDificultad = idDificultad;
    }

    public Dificultad(Integer idDificultad, String descripcion, boolean activo, Date fechaRegistro) {
        this.idDificultad = idDificultad;
        this.descripcion = descripcion;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdDificultad() {
        return idDificultad;
    }

    public void setIdDificultad(Integer idDificultad) {
        this.idDificultad = idDificultad;
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

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
    }
}
