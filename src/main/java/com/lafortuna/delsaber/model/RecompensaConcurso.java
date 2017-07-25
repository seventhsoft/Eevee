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

public class RecompensaConcurso implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idRecompensaConcurso;
    private int cantidad;
    private Concurso concurso;
    private Recompensa recompensa;
    private List<JugadorRecompensa> jugadorRecompensaList;

    public RecompensaConcurso() {
    }

    public RecompensaConcurso(Integer idRecompensaConcurso) {
        this.idRecompensaConcurso = idRecompensaConcurso;
    }

    public RecompensaConcurso(Integer idRecompensaConcurso, int cantidad) {
        this.idRecompensaConcurso = idRecompensaConcurso;
        this.cantidad = cantidad;
    }

    public Integer getIdRecompensaConcurso() {
        return idRecompensaConcurso;
    }

    public void setIdRecompensaConcurso(Integer idRecompensaConcurso) {
        this.idRecompensaConcurso = idRecompensaConcurso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Concurso getConcurso() {
        return concurso;
    }

    public void setConcurso(Concurso concurso) {
        this.concurso = concurso;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public List<JugadorRecompensa> getJugadorRecompensaList() {
        return jugadorRecompensaList;
    }

    public void setJugadorRecompensaList(List<JugadorRecompensa> jugadorRecompensaList) {
        this.jugadorRecompensaList = jugadorRecompensaList;
    }
}
