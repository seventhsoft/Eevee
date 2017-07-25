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
 * @author Cliente
 */

public class JugadorRecompensa implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idJugadorRecompensa;
    private String codigo;
    private String observacion;
    private Boolean redimido;
    private Date fechaRedimido;
    private Date fechaRegistro;
    private Jugador jugador;
    private RecompensaConcurso recompensaConcurso;

    public JugadorRecompensa() {
    }

    public JugadorRecompensa(Integer idJugadorRecompensa) {
        this.idJugadorRecompensa = idJugadorRecompensa;
    }

    public JugadorRecompensa(Integer idJugadorRecompensa, Date fechaRegistro) {
        this.idJugadorRecompensa = idJugadorRecompensa;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdJugadorRecompensa() {
        return idJugadorRecompensa;
    }

    public void setIdJugadorRecompensa(Integer idJugadorRecompensa) {
        this.idJugadorRecompensa = idJugadorRecompensa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getRedimido() {
        return redimido;
    }

    public void setRedimido(Boolean redimido) {
        this.redimido = redimido;
    }

    public Date getFechaRedimido() {
        return fechaRedimido;
    }

    public void setFechaRedimido(Date fechaRedimido) {
        this.fechaRedimido = fechaRedimido;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public RecompensaConcurso getRecompensaConcurso() {
        return recompensaConcurso;
    }

    public void setRecompensaConcurso(RecompensaConcurso recompensaConcurso) {
        this.recompensaConcurso = recompensaConcurso;
    }
}
