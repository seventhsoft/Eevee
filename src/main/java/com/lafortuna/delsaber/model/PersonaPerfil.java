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

public class PersonaPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPersonaPerfil;
    private Perfil perfil;
    private Persona persona;

    public PersonaPerfil() {
    }

    public PersonaPerfil(Integer idPersonaPerfil) {
        this.idPersonaPerfil = idPersonaPerfil;
    }

    public Integer getIdPersonaPerfil() {
        return idPersonaPerfil;
    }

    public void setIdPersonaPerfil(Integer idPersonaPerfil) {
        this.idPersonaPerfil = idPersonaPerfil;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
