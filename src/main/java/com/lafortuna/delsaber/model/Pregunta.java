/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cliente
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPregunta;
    private String descripcion;
    private String ruta;
    private String clase;
    private String bannerPregunta;
    private boolean activo;
    private Date fechaRegistro;
    private Dificultad dificultad;
    private List<PreguntaMensaje> preguntaMensajeList;
    private List<Respuesta> respuestaList;

    public Pregunta() {
    }

    public void setBannerPregunta(String bannerPregunta) {
        this.bannerPregunta = bannerPregunta;
    }

    public String getBannerPregunta() {
        return bannerPregunta;
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(Integer idPregunta, String descripcion, String ruta, String clase, boolean activo, Date fechaRegistro) {
        this.idPregunta = idPregunta;
        this.descripcion = descripcion;
        this.ruta = ruta;
        this.clase = clase;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
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

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public List<PreguntaMensaje> getPreguntaMensajeList() {
        return preguntaMensajeList;
    }

    public void setPreguntaMensajeList(List<PreguntaMensaje> preguntaMensajeList) {
        this.preguntaMensajeList = preguntaMensajeList;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }
}
