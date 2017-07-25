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
public class Anunciante implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAnunciante;
    private List<Campana> campanaList;
    private Persona persona;

    public Anunciante() {
    }

    public Anunciante(Integer idAnunciante) {
        this.idAnunciante = idAnunciante;
    }

    public Integer getIdAnunciante() {
        return idAnunciante;
    }

    public void setIdAnunciante(Integer idAnunciante) {
        this.idAnunciante = idAnunciante;
    }

    public List<Campana> getCampanaList() {
        return campanaList;
    }

    public void setCampanaList(List<Campana> campanaList) {
        this.campanaList = campanaList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
