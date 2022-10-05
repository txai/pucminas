package com.receba.servicoiniciativas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.receba.servicoiniciativas.models.Iniciativa;
import com.receba.servicoiniciativas.services.IniciativaService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/iniciativas")
public class IniciativaController {
    
    @Autowired
    IniciativaService iniciativaService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public Flux<Iniciativa> findAll() {
        Flux<Iniciativa> iniciativas = iniciativaService.findAll();
        return iniciativas;
    }
}
