/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Cliente
 */

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idUsuario;
    private String usuario;
    private String password;
    private boolean activo;
    private Date fechaRegistro;
    private Persona persona;
    private Integer idPerfil;
    private boolean facebook;

    public Usuario() {
        persona = new Persona();
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String usuario, String password, boolean activo, Date fechaRegistro, Integer idPerfil) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
        this.idPerfil = idPerfil;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the idPerfil
     */
    public Integer getIdPerfil() {
        return idPerfil;
    }

    /**
     * @param idPerfil the idPerfil to set
     */
    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    /**
     * @return the facebook
     */
    public boolean isFacebook() {
        return facebook;
    }

    /**
     * @param facebook the facebook to set
     */
    public void setFacebook(boolean facebook) {
        this.facebook = facebook;
    }
}
