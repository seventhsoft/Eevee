/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.banner;

import com.lafortuna.delsaber.repository.BannerMapper;
import com.lafortuna.delsaber.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Andres
 */
public class BannerServiceImpl extends GenericService implements BannerService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private BannerMapper bannerMapper;
    
    @Override
    public void updateAgregaInteraccion(Integer idBanner) {
        if(objetoValido(idBanner)){
            bannerMapper.updateAgregaInteraccionBanner(idBanner);
        }
    }
    
}
