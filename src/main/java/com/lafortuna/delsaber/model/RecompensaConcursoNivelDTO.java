/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.model;

import java.io.Serializable;

/**
 *
 * @author cliente
 */
public class RecompensaConcursoNivelDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private Integer idRecompensaConcurso;
    private String codigo;

    public RecompensaConcursoNivelDTO(){
   
    }
    
    public RecompensaConcursoNivelDTO(String descripcion, Integer idRecompensaConcurso, String codigo ){
        this.descripcion = descripcion;
        this.idRecompensaConcurso = idRecompensaConcurso;
        this.codigo = codigo;
    }
    
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the idRecompensaConcurso
     */
    public Integer getIdRecompensaConcurso() {
        return idRecompensaConcurso;
    }

    /**
     * @param idRecompensaConcurso the idRecompensaConcurso to set
     */
    public void setIdRecompensaConcurso(Integer idRecompensaConcurso) {
        this.idRecompensaConcurso = idRecompensaConcurso;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
