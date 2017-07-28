/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.model.User;
import com.lafortuna.delsaber.repository.JugadorMapper;
import com.lafortuna.delsaber.rest.GenericRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Cliente
 */
public abstract class GenericService extends GenericRestService {
    
    @Autowired
    private JugadorMapper jugadorMapper;
    
    @Transactional(readOnly = false)
    public Integer getidJugadorByUser(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return this.jugadorMapper.getJugadorByIdPersona(user.getUsuario().getPersona().getIdPersona());
    }
    
    public Integer getidPersona(Authentication auth) {
        User user = (User) auth.getPrincipal();
        return user.getUsuario().getPersona().getIdPersona();
    }
}
