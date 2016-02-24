/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melayer.camzia.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aniruddha
 */
@RestController(value = "/admin")
public class MeControllerAdmin {

    @Autowired
    private Map<String, Object> entityMap;

    @RequestMapping(path = "/check", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Callable<ResponseEntity<Map<String, Object>>> checkWebServices() {

        return () -> {

            entityMap.clear();
            entityMap.put("status", "working fine");

            ResponseEntity<Map<String, Object>> entity = new ResponseEntity<>(entityMap, HttpStatus.OK);

            return entity;
        };
    }

    @RequestMapping(path = "/securityLess", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Callable<ResponseEntity<Map<String, Object>>> checkWithoutSecurity() {

        return () -> {

            entityMap.clear();
            entityMap.put("status", "It is securityless");

            ResponseEntity<Map<String, Object>> entity = new ResponseEntity<>(entityMap, HttpStatus.OK);

            return entity;
        };
    }
}
