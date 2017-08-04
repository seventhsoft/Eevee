/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest;

import com.lafortuna.delsaber.exception.BadRequestException;
import com.lafortuna.delsaber.exception.InternalServerException;
import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.exception.NoUserAuthenticatedException;
import com.lafortuna.delsaber.exception.NotFoundException;
import com.lafortuna.delsaber.exception.ConflictException;
import com.lafortuna.delsaber.exception.ErrorResponse;
import com.lafortuna.delsaber.exception.NonAuthoritativeInformation;
import com.lafortuna.delsaber.model.User;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author mario.martinez
 */
public abstract class GenericRestService<E> {          
    
    public User getUserAuthenticated(Authentication auth) throws NoUserAuthenticatedException {
        User user = (User)auth.getPrincipal();
        if(!(user != null))
        {
            throw  new NoUserAuthenticatedException();
        }        
        return user;
    }
    
    public Integer getIdPerfilUser(Authentication auth) throws NoUserAuthenticatedException {
        return getUserAuthenticated(auth).getUsuario().getIdUsuario();
    }
    
    public Integer getIdUser(Authentication auth) throws NoUserAuthenticatedException {
        return getUserAuthenticated(auth).getUsuario().getIdUsuario();
    }
    
    public boolean listaValida(List l) {
        return (l != null && !l.isEmpty());
    }
    
    public boolean objetoValido(E e) {
        return e != null;
    }
    
      /**
     * Manejador de excepciones para recursos no solicitados, se regresa status 404
     * @param e
     * @return 
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFound( NotFoundException e) {
        return new ErrorResponse(HttpStatus.PRECONDITION_FAILED.value(), "recurso no encontrado " +  e.getMessage());
    }
    
    /**
     * Manejador de excepciones para contenidos inexistentes, se regresa status 204
     * @param e
     * @return 
     */
    @ExceptionHandler(NoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ErrorResponse noContent( NoContentException e) {
        return new ErrorResponse(HttpStatus.PRECONDITION_FAILED.value(), "no hay resultados para " +  e.getMessage());
    }
    
    /**
     * Manejador de excepciones para conflictos al insertar datos, se regresa 409
     * @param e
     * @return 
     */
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse conlict( ConflictException e) {
        return new ErrorResponse(HttpStatus.PRECONDITION_FAILED.value(), "el registro ya existe " +  e.getMessage());
    }  
    
    /**
     * Manejador de excepciones para conflictos al insertar datos, se regresa 409
     * @param e
     * @return 
     */
    @ExceptionHandler(NoUserAuthenticatedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorResponse noAthenticated( NoUserAuthenticatedException e) {
        return new ErrorResponse(HttpStatus.PRECONDITION_FAILED.value(), "Usuario no authorizado " +  e.getMessage());
    }
    
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest( BadRequestException e) {
        return new ErrorResponse(HttpStatus.PRECONDITION_FAILED.value(), "Error en el rquest! " +  e.getMessage());
    }
    
    
    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse internalServerError( InternalServerException e) {
        return new ErrorResponse(HttpStatus.PRECONDITION_FAILED.value(), "Error al realizar el proceso! " +  e.getMessage());
    }
    
    @ExceptionHandler(NonAuthoritativeInformation.class)
    @ResponseStatus(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
    public ErrorResponse nonAuthoritativeInformation(NonAuthoritativeInformation e){
        return new ErrorResponse(HttpStatus.NON_AUTHORITATIVE_INFORMATION.value(),e.getMessage());
    }
} 
