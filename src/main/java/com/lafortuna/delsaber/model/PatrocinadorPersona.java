/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

/**
 *
 * @author cliente
 */
public class PatrocinadorPersona {
    
    private Integer idPersona;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String correo;
    private String organizacion;
    private Integer idUsuario;
    private String usuario;
    private Integer idPatrocinador;

    /**
     * @return the idPersona
     */
    public Integer getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apaterno
     */
    public String getApaterno() {
        return apaterno;
    }

    /**
     * @param apaterno the apaterno to set
     */
    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    /**
     * @return the amaterno
     */
    public String getAmaterno() {
        return amaterno;
    }

    /**
     * @param amaterno the amaterno to set
     */
    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the organizacion
     */
    public String getOrganizacion() {
        return organizacion;
    }

    /**
     * @param organizacion the organizacion to set
     */
    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the idPatrocinador
     */
    public Integer getIdPatrocinador() {
        return idPatrocinador;
    }

    /**
     * @param idPatrocinador the idPatrocinador to set
     */
    public void setIdPatrocinador(Integer idPatrocinador) {
        this.idPatrocinador = idPatrocinador;
    }
}
