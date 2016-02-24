/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melayer.camzia.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author aniruddha
 */
@Configuration
public class MeConfigApp {
    
    @Bean
    public Map<String, Object> mapEntity(){
        
        Map<String,Object> map = new HashMap<>();
        
        return map;
    }
}
