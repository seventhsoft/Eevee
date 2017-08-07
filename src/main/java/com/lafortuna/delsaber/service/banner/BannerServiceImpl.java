/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.banner;

import com.lafortuna.delsaber.exception.NoContentException;
import com.lafortuna.delsaber.model.Banner;
import com.lafortuna.delsaber.repository.BannerMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.service.MailContentBuilder;
import com.lafortuna.delsaber.service.MailService;
import com.lafortuna.delsaber.util.Constant;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class BannerServiceImpl extends GenericService implements BannerService{
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private BannerMapper bannerMapper;
    
    @Autowired
    public MailContentBuilder mailContentBuilder;
    
    @Override
    public String updateAgregaInteraccion(Integer idBanner) {
        if(objetoValido(idBanner)){
            Banner banner = this.bannerMapper.getBannerById(idBanner);
            if(objetoValido(banner)){
                String ruta = banner.getRuta();
                this.bannerMapper.updateAgregaInteraccionBanner(idBanner);
                return ruta;
            }
            throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
        }
        throw new NoContentException(Constant.NO_CONTENT_MESSAGE);
    }
    
}
