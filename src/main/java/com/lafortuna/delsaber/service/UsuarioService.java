/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.model.Persona;
import com.lafortuna.delsaber.model.PersonaUsuarioPerfil;
import com.lafortuna.delsaber.model.Usuario;
import java.util.List;
import org.springframework.security.core.Authentication;

/**
 *
 * @author Cliente
 */
public interface UsuarioService {
    Usuario getUsuarioByUserName(String username);
    List<Usuario>getUsuarioAll();
    Usuario getUsuarioById(Integer idUsuario);
    void insertUsuarioPersonaPerfil(PersonaUsuarioPerfil personaUsuarioPerfil);
    void deleteUsuarioPersonaPerfil(PersonaUsuarioPerfil personaUsuarioPerfil);
    void updateUsuarioPersona(PersonaUsuarioPerfil personaUsuarioPerfil, Authentication auth);
    void updateJugadorActivo(PersonaUsuarioPerfil personaUsuarioPerfil);
    void postRecuperarPassword(PersonaUsuarioPerfil personaUsuarioPerfil);
    void updateRecuperarPassword(PersonaUsuarioPerfil p, String token);
}
