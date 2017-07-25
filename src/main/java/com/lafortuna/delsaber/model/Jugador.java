/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cliente
 */

public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idJugador;
    private List<JugadorNivel> jugadorNivelList;
    private Persona persona;
    private List<JugadorRecompensa> jugadorRecompensaList;

    public Jugador() {
    }

    public Jugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public List<JugadorNivel> getJugadorNivelList() {
        return jugadorNivelList;
    }

    public void setJugadorNivelList(List<JugadorNivel> jugadorNivelList) {
        this.jugadorNivelList = jugadorNivelList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<JugadorRecompensa> getJugadorRecompensaList() {
        return jugadorRecompensaList;
    }

    public void setJugadorRecompensaList(List<JugadorRecompensa> jugadorRecompensaList) {
        this.jugadorRecompensaList = jugadorRecompensaList;
    }
}
