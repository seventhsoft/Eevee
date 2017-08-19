/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.math.BigDecimal;

/**
 *
 * @author Cliente
 */
public class PorcionSerieDTO {
    private long preguntas;
    private BigDecimal disponibles; 
    private int dificultad;

    /**
     * @return the preguntas
     */
    public long getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas the preguntas to set
     */
    public void setPreguntas(long preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return the disponibles
     */
    public BigDecimal getDisponibles() {
        return disponibles;
    }

    /**
     * @param disponibles the disponibles to set
     */
    public void setDisponibles(BigDecimal disponibles) {
        this.disponibles = disponibles;
    }

    /**
     * @return the dificultad
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * @param dificultad the dificultad to set
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }
    
    
}
