package com.receba.iniciativaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receba.iniciativaservice.models.Iniciativa;
import com.receba.iniciativaservice.services.IniciativaService;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/iniciativas")
public class IniciativaController {
    
    @Autowired
    IniciativaService iniciativaService;

    @GetMapping
    public Flux<Iniciativa> findAll() {
        return iniciativaService.findAll();
    }
}
