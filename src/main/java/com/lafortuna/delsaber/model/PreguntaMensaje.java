/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cliente
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PreguntaMensaje implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPreguntaMensaje;
    private Integer idPregunta;
    private Integer idPatrocinador;
    private Integer idConcurso;
    private Boolean activo;
    private Date fechaRegistro;
    private Concurso concurso;
    private Patrocinador patrocinador;
    private Pregunta pregunta;

    public PreguntaMensaje() {
    }

    public PreguntaMensaje(Integer idPreguntaMensaje) {
        this.idPreguntaMensaje = idPreguntaMensaje;
    }

    public PreguntaMensaje(Integer idPreguntaMensaje, boolean activo, Date fechaRegistro) {
        this.idPreguntaMensaje = idPreguntaMensaje;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPreguntaMensaje() {
        return idPreguntaMensaje;
    }

    public void setIdPreguntaMensaje(Integer idPreguntaMensaje) {
        this.idPreguntaMensaje = idPreguntaMensaje;
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

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPatrocinador(Integer idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public Integer getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdConcurso(Integer idConcurso) {
        this.idConcurso = idConcurso;
    }

    public Integer getIdConcurso() {
        return idConcurso;
    }
}
