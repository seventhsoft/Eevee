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
 */
public class RespuestaDTO {
    
    private Integer idRespuesta;
    private Integer idPregunta;
    private String descripcion;
    private Integer orden;
    private Boolean correcta;
    private Boolean activo;
    private Date fechaRegistro;

    /**
     * @return the idRespuesta
     */
    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    /**
     * @param idRespuesta the idRespuesta to set
     */
    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    /**
     * @return the idPregunta
     */
    public Integer getIdPregunta() {
        return idPregunta;
    }

    /**
     * @param idPregunta the idPregunta to set
     */
    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
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
     * @return the orden
     */
    public Integer getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    /**
     * @return the correcta
     */
    public Boolean getCorrecta() {
        return correcta;
    }

    /**
     * @param correcta the correcta to set
     */
    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
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
