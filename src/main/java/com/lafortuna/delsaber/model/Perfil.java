/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cliente
 */

public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPerfil;
    private String descripcion;
    private String tarjet;
    private boolean activo;
    private Date fechaRegistro;
    private List<PersonaPerfil> personaPerfilList;

    public Perfil() {
    }

    public Perfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Perfil(Integer idPerfil, String descripcion, String tarjet, boolean activo, Date fechaRegistro) {
        this.idPerfil = idPerfil;
        this.descripcion = descripcion;
        this.tarjet = tarjet;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTarjet() {
        return tarjet;
    }

    public void setTarjet(String tarjet) {
        this.tarjet = tarjet;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public List<PersonaPerfil> getPersonaPerfilList() {
        return personaPerfilList;
    }

    public void setPersonaPerfilList(List<PersonaPerfil> personaPerfilList) {
        this.personaPerfilList = personaPerfilList;
    }
}
