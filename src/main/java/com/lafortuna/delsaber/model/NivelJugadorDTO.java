/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;

/**
 *
 * @author nestor.arias
 */
public class NivelJugadorDTO implements Serializable {
    
    private Integer nivel;
    private Integer series;
    private Integer seriesJugador;
    private Boolean tieneRecompensa;
    private Integer recompensasDisponibles;

    /**
     * @return the nivel
     */
    public Integer getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the series
     */
    public Integer getSeries() {
        return series;
    }

    /**
     * @param series the series to set
     */
    public void setSeries(Integer series) {
        this.series = series;
    }

    /**
     * @return the seriesJugador
     */
    public Integer getSeriesJugador() {
        return seriesJugador;
    }

    /**
     * @param seriesJugador the seriesJugador to set
     */
    public void setSeriesJugador(Integer seriesJugador) {
        this.seriesJugador = seriesJugador;
    }

    /**
     * @return the tieneRecompensa
     */
    public Boolean getTieneRecompensa() {
        return tieneRecompensa;
    }

    /**
     * @param tieneRecompensa the tieneRecompensa to set
     */
    public void setTieneRecompensa(Boolean tieneRecompensa) {
        this.tieneRecompensa = tieneRecompensa;
    }

    /**
     * @return the recompensasDisponibles
     */
    public Integer getRecompensasDisponibles() {
        return recompensasDisponibles;
    }

    /**
     * @param recompensasDisponibles the recompensasDisponibles to set
     */
    public void setRecompensasDisponibles(Integer recompensasDisponibles) {
        this.recompensasDisponibles = recompensasDisponibles;
    }
}
    
    