/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service;

import com.lafortuna.delsaber.exception.ConflictException;
import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.exception.NonAuthoritativeInformation;
import com.lafortuna.delsaber.model.PasswordToken;
import com.lafortuna.delsaber.model.Perfil;
import com.lafortuna.delsaber.model.PersonaUsuarioPerfil;
import com.lafortuna.delsaber.model.Role;
import com.lafortuna.delsaber.model.User;
import com.lafortuna.delsaber.model.Usuario;
import com.lafortuna.delsaber.repository.PasswordTokenMapper;
import com.lafortuna.delsaber.repository.PerfilMapper;
import com.lafortuna.delsaber.repository.UsuarioMapper;
import com.lafortuna.delsaber.util.Constant;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 *
 * @author Cliente
 */
@Service("userDetailsServiceImpl")
public class UsuarioServiceImpl extends GenericService implements UserDetailsService, UsuarioService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Autowired
    private PerfilMapper perfilMapper;
    
    @Autowired
    private MailService mailService;
    
    @Autowired
    private PasswordTokenMapper passwordTokenMapper;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsuario(usuarioMapper.getUsuarioByUserName(username));
        if(objetoValido(user.getUsuario())) {
            List<Perfil> roles = perfilMapper.getPerfilByIdPersona(user.getUsuario().getPersona().getIdPersona());
        roles.stream().forEach(p -> {
            Role r =  new Role();
            r.setName(p.getTarjet());
            user.getAuthorities().add(r);
        });
        return user;
        } else {
            throw new UsernameNotFoundException("usuario no registrado");
        }
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioByUserName(String username) {
        return usuarioMapper.getUsuarioByUserName(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> getUsuarioAll() {
       List<Usuario> userList =  this.usuarioMapper.getUsuarioAll();
       if(listaValida(userList)) { return userList;}
       throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario getUsuarioById(Integer idUsuario) {
        Usuario user =  this.usuarioMapper.getUsuarioById(idUsuario);
        if(objetoValido(user)){ return user;}
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUsuarioPersonaPerfil(PersonaUsuarioPerfil personaUsuarioPerfil) {
        try {
            this.usuarioMapper.insertPersona(personaUsuarioPerfil);
            if(objetoValido(personaUsuarioPerfil.getPassword())) {
                personaUsuarioPerfil.setPassword(this.passwordEncoder.encode(personaUsuarioPerfil.getPassword()));
            }
            this.usuarioMapper.insertUsuario(personaUsuarioPerfil);
            this.usuarioMapper.insertPersonaPerfil(personaUsuarioPerfil);
            switch(personaUsuarioPerfil.getIdPerfil())
            {  
                case Constant.JUGADOR:
                    if(this.usuarioMapper.getValidatecorreo(personaUsuarioPerfil.getCorreo())){
                        throw new ConflictException("error, el correo ya ha sido registrado ");
                    }
                    this.usuarioMapper.insertJugador(personaUsuarioPerfil);
                    if(personaUsuarioPerfil.isActivo().equals(Boolean.TRUE)){
                        String parametros = "#?tipo=1"+"&iu="+personaUsuarioPerfil.getIdUsuario();
                        this.mailService.enviaCorreoRegistro(personaUsuarioPerfil.getCorreo(), parametros);
                    }
                    break;
                case Constant.PATROCINADOR:
                    this.usuarioMapper.insertPatrocinador(personaUsuarioPerfil);
                    break;
                case Constant.ANUNCIANTE:
                    this.usuarioMapper.insertAnunciante(personaUsuarioPerfil);
                    break;
                default:
                    break;
            }
        } catch (MailException | DataAccessException e) {
            this.log.error(this.getClass().getName() + ":insertUsuarioPersonaPerfil ex:" + e);
            throw new InternalServerException("Error al guardar usuario ex: "+e); 
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUsuarioPersonaPerfil(PersonaUsuarioPerfil personaUsuarioPerfil) {
        try {
            this.usuarioMapper.deleteUsuario(personaUsuarioPerfil);
            this.usuarioMapper.deletePersonaPerfil(personaUsuarioPerfil);
            this.usuarioMapper.deletePersona(personaUsuarioPerfil);
        } catch (DataAccessException e) {
            this.log.error(this.getClass().getName() + ":deleteUsuarioPersonaPerfil ex:" + e);
            throw new InternalServerException("Error al eliminar usuario ex: "+e); 
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUsuarioPersona(PersonaUsuarioPerfil personaUsuarioPerfil, Authentication auth) {
        try {
            personaUsuarioPerfil.setIdUsuario(getIdUser(auth));
            personaUsuarioPerfil.setIdPersona(getidPersona(auth));

            encodePassword(personaUsuarioPerfil, auth);
            if (personaUsuarioPerfil.getPassword() != null) {
                this.usuarioMapper.updateUsuario(personaUsuarioPerfil);               
            }
            if (personaUsuarioPerfil.getNombre() != null || personaUsuarioPerfil.getApaterno() != null) {
                this.usuarioMapper.updatePersona(personaUsuarioPerfil);
            }
        } catch (DataAccessException e) {
            this.log.error(this.getClass().getName() + ":updateUsuarioPersona ex:" + e);
            throw new InternalServerException("Error al actualizar usuario ex: " + e);
        }  
    }
    
    private void encodePassword(PersonaUsuarioPerfil pu, Authentication auth ){
        Usuario user = this.usuarioMapper.getUsuarioByUserName(auth.getName());
        if (objetoValido(pu) && !StringUtils.isEmpty(pu.getPassword())) {
            if (this.passwordEncoder.matches(pu.getPasswordAnterior(), user.getPassword())) {
                pu.setPassword(this.passwordEncoder.encode(pu.getPassword()));
            }else{
                throw new BadCredentialsException("la contraseña no coincide");
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateJugadorActivo(PersonaUsuarioPerfil personaUsuarioPerfil) {
        try{
            this.usuarioMapper.updateJugadorActivo(personaUsuarioPerfil);
        } catch (DataAccessException e) {
            this.log.error(this.getClass().getName() + ":updateJugadorActivo ex:" + e);
            throw new InternalServerException("Error al actualizar jugador activo ex: "+e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void postRecuperarPassword(PersonaUsuarioPerfil personaUsuarioPerfil) {
        try{
            if(objetoValido(personaUsuarioPerfil.getUsuario()) ) {
                Usuario usuario = getUsuarioByUserName(personaUsuarioPerfil.getUsuario());
                if(!objetoValido(usuario)){
                    throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
                }
                if(usuario.isFacebook()){
                    throw new NonAuthoritativeInformation("Usuario de facebook!");
                }
                PasswordToken pt = this.passwordTokenMapper.getPasswordToken(usuario.getIdUsuario());
                if(!objetoValido(pt) ) {
                    String llave = UUID.randomUUID().toString();
                    llave = llave.replaceAll("-", "");
                    pt = new PasswordToken();
                    pt.setIdUsuario(usuario.getIdUsuario());
                    pt.setToken(llave);                
                    this.passwordTokenMapper.insertPasswordToken(pt);
                }                
                
                String parametros = "#?tipo=2"+"&iu="+pt.getIdUsuario()+"&key="+pt.getToken();
                this.mailService.enviaCorreoRecuperar(usuario.getPersona().getCorreo() ,usuario.getUsuario(),parametros);
            }
        }catch(MailException | DataAccessException e){
            this.log.error(this.getClass().getName() + ":postRecuperarPassword ex:" + e);
            throw new InternalServerException("Error al cambiar password ex: " + e);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateRecuperarPassword(PersonaUsuarioPerfil personaUsuarioPerfil, String token) {
        try {
            PasswordToken pt = this.passwordTokenMapper.getPasswordToken(personaUsuarioPerfil.getIdUsuario());
            if(objetoValido(pt) && !pt.isActivo() && pt.getToken().equals(token)) {
                if(personaUsuarioPerfil.getIdUsuario() != null && personaUsuarioPerfil.getPassword() != null) {   
                    personaUsuarioPerfil.setPassword(this.passwordEncoder.encode(personaUsuarioPerfil.getPassword()));
                    this.usuarioMapper.updateRecuperarPassword(personaUsuarioPerfil);
                    pt.setActivo(Boolean.TRUE);
                    this.passwordTokenMapper.updatePasswordToken(pt);
                }
            } else {
                throw new NoContentException("Enlace caducado");
            }
            
        } catch (DataAccessException e) {
            this.log.error(this.getClass().getName() + ":updateRecuperarPassword ex:" + e);
            throw new InternalServerException("Error al actualizar el password del usuario ex: "+e);           
        }  
    }
    
}
