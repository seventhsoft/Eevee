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

public class Patrocinador implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPatrocinador;
    private List<Recompensa> recompensaList;
    private List<PreguntaMensaje> preguntaMensajeList;
    private Persona persona;

    public Patrocinador() {
    }

    public Patrocinador(Integer idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public Integer getIdPatrocinador() {
        return idPatrocinador;
    }

    public void setIdPatrocinador(Integer idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }

    public List<Recompensa> getRecompensaList() {
        return recompensaList;
    }

    public void setRecompensaList(List<Recompensa> recompensaList) {
        this.recompensaList = recompensaList;
    }

    public List<PreguntaMensaje> getPreguntaMensajeList() {
        return preguntaMensajeList;
    }

    public void setPreguntaMensajeList(List<PreguntaMensaje> preguntaMensajeList) {
        this.preguntaMensajeList = preguntaMensajeList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
