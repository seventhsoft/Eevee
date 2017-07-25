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
public class NotFoundException extends GlobalException{ 

    public NotFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NotFoundException() {
        super();
    }        
   
}
