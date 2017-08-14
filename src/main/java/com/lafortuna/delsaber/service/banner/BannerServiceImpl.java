/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.service.banner;

import com.lafortuna.delsaber.model.Banner;
import com.lafortuna.delsaber.repository.BannerMapper;
import com.lafortuna.delsaber.service.GenericService;
import com.lafortuna.delsaber.service.MailContentBuilder;
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
        Map<String,String> parametros = new HashMap<>();
        String ruta = "http://127.0.0.1";
        if(objetoValido(idBanner)){
            Banner banner = this.bannerMapper.getBannerById(idBanner);
            if(objetoValido(banner)){
                this.bannerMapper.updateAgregaInteraccionBanner(idBanner);
                ruta = banner.getRuta();
            }
        }
        parametros.put("ruta", ruta);
        return this.mailContentBuilder.build(Constant.BANNER_HTML_TEMPLATE,parametros);
    }
    
}
