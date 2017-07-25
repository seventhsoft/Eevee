/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.exception;

/**
 *
 * @author mario.martinez
 */
public class NoUserAuthenticatedException extends GlobalException {

    public NoUserAuthenticatedException() {
        super();
    }
    
    public NoUserAuthenticatedException(String errorMessage) {
        super(errorMessage);
    }
    
}
