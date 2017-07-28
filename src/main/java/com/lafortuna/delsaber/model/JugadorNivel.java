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

public class JugadorNivel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idJugadorNivel;
    private Integer serieActual;
    private Jugador jugador;
    private Nivel nivel;
    private List<Serie> serieList;
    private Integer dNivel;

    public JugadorNivel() {
    }

    public JugadorNivel(Integer idJugadorNivel) {
        this.idJugadorNivel = idJugadorNivel;
    }

    public Integer getIdJugadorNivel() {
        return idJugadorNivel;
    }

    public void setIdJugadorNivel(Integer idJugadorNivel) {
        this.idJugadorNivel = idJugadorNivel;
    }

    public Integer getSerieActual() {
        return serieActual;
    }

    public void setSerieActual(Integer serieActual) {
        this.serieActual = serieActual;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Serie> getSerieList() {
        return serieList;
    }

    public void setSerieList(List<Serie> serieList) {
        this.serieList = serieList;
    }

    /**
     * @return the dNivel
     */
    public Integer getdNivel() {
        return dNivel;
    }

    /**
     * @param dNivel the dNivel to set
     */
    public void setdNivel(Integer dNivel) {
        this.dNivel = dNivel;
    }
}
