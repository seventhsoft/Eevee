/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cliente
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idPersona;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private String correo;
    private String organizacion;
    private String telefono;
    private boolean activo;
    private Date fechaRegistro;
    private List<PersonaPerfil> personaPerfilList;
    private List<Jugador> jugadorList;
    private List<Patrocinador> patrocinadorList;
    private List<Usuario> usuarioList;
    private List<Anunciante> anuncianteList;

    public Persona() {
    }

    public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombre, String apaterno, String amaterno, String correo, String organizacion, String telefono, boolean activo, Date fechaRegistro) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.correo = correo;
        this.organizacion = organizacion;
        this.telefono = telefono;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno + " " + (amaterno == null ? "" : amaterno);
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public List<Patrocinador> getPatrocinadorList() {
        return patrocinadorList;
    }

    public void setPatrocinadorList(List<Patrocinador> patrocinadorList) {
        this.patrocinadorList = patrocinadorList;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<Anunciante> getAnuncianteList() {
        return anuncianteList;
    }

    public void setAnuncianteList(List<Anunciante> anuncianteList) {
        this.anuncianteList = anuncianteList;
    }
}
