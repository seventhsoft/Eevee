/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest;

import com.lafortuna.delsaber.model.PersonaUsuarioPerfil;
import com.lafortuna.delsaber.model.Usuario;
import com.lafortuna.delsaber.service.MailService;
import com.lafortuna.delsaber.service.UsuarioService;
import java.util.List;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cliente
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestService extends GenericRestService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private MailService mailService;
    
    @RequestMapping(value = "/test",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void getTest() {
        this.log.info("#########################Log usuario Service!");
        String parametros = "#?tipo=1&iu=2";
        this.mailService.enviaCorreoRegistro("andres.ahedo@gmail.com", parametros);
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Usuario> getUsuarioAll()
    throws NotFoundException{
        return this.usuarioService.getUsuarioAll();
    }
    
    @RequestMapping(value = "/{idUsuario}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario getUsuarioById(
            @PathVariable("idUsuario")Integer idUsuario)
    throws NotFoundException{
        return this.usuarioService.getUsuarioById(idUsuario);
    }
    
    @RequestMapping(value = "/perfil",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario geUserProfile(Authentication auth)
    throws NotFoundException{
        return this.usuarioService.getUsuarioById(getIdUser(auth));
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void insertUsuarioPersonaPerfil(@RequestBody PersonaUsuarioPerfil personaUsuarioPerfil){
        this.usuarioService.insertUsuarioPersonaPerfil(personaUsuarioPerfil);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteUsuarioPersonaPerfil(@RequestBody PersonaUsuarioPerfil personaUsuarioPerfil){
        this.usuarioService.deleteUsuarioPersonaPerfil(personaUsuarioPerfil);
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateUsuarioPersona(@RequestBody PersonaUsuarioPerfil personaUsuarioPerfil, Authentication auth){
        this.usuarioService.updateUsuarioPersona(personaUsuarioPerfil, auth);
    }
    
    @RequestMapping(value = "/jugadores/activar/{id}",method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String updateJugadorActivo(@PathVariable("id") int idUsuario) {
        PersonaUsuarioPerfil p = new PersonaUsuarioPerfil();
        p.setIdUsuario(idUsuario);
        p.setActivo(Boolean.FALSE);
        this.usuarioService.updateJugadorActivo(p);
        return "usuario activo!";
    }
    
    @RequestMapping(value = "/recuperar/password",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void postRecuperarPassword(@RequestBody PersonaUsuarioPerfil personaUsuarioPerfil) {
        this.usuarioService.postRecuperarPassword(personaUsuarioPerfil);
    }
    
    @RequestMapping(value = "/recuperar/password/{token}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateRecuperarPassword(@RequestBody PersonaUsuarioPerfil personaUsuarioPerfil, @PathVariable("token") String token) {
        this.usuarioService.updateRecuperarPassword(personaUsuarioPerfil, token);
    }
}
