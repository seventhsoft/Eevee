/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cliente
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JugadorNivel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idJugadorNivel;
    private Integer serieActual;
    private Jugador jugador;
    private Nivel nivel;
    private List<Serie> serieList;
    private Integer idNivel;
    private Integer idJugador;
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
     * @return the idNivel
     */
    public Integer getIdNivel() {
        return idNivel;
    }

    /**
     * @param idNivel
     */
    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setdNivel(Integer dNivel) {
        this.dNivel = dNivel;
    }

    public Integer getdNivel() {
        return dNivel;
    }
    
}
