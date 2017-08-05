/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lafortuna.delsaber.rest.banner;

import com.lafortuna.delsaber.rest.GenericRestService;
import com.lafortuna.delsaber.service.banner.BannerService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/banner")
public class BannerRestService extends GenericRestService{
 
    @Autowired
    private BannerService bannerService;
    
    @RequestMapping(value = "/interaccion/{idBanner}", method = RequestMethod.PUT)
    public Map<String, String> updateAgregaInteraccion(@PathVariable("idBanner")Integer idBanner) {       
        Map<String,String> map = new HashMap<>();
        map.put("msg", "ok");
        this.bannerService.updateAgregaInteraccion(idBanner);
        return map;
    }
    
}