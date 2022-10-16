package com.receba.iniciativaservice.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.receba.iniciativaservice.models.Iniciativa;
import com.receba.iniciativaservice.repositories.IniciativaRepository;

import reactor.core.publisher.Flux;

public class IniciativaServiceImpl implements IniciativaService{
    @Autowired
    IniciativaRepository iniciativaRepository;

    public Flux<Iniciativa> findAll(){
        return iniciativaRepository.findAll();
    }
}
