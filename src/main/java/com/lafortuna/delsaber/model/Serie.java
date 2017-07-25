/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;

/**
 *
 * @author Cliente
 */

public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idSerie;
    private int serie;
    private JugadorNivel jugadorNivel;
    private Respuesta respuesta;

    public Serie() {
    }

    public Serie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public Serie(Integer idSerie, int serie) {
        this.idSerie = idSerie;
        this.serie = serie;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public JugadorNivel getJugadorNivel() {
        return jugadorNivel;
    }

    public void setJugadorNivel(JugadorNivel jugadorNivel) {
        this.jugadorNivel = jugadorNivel;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }
}
