package com.receba.servicoiniciativas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receba.servicoiniciativas.models.Iniciativa;
import com.receba.servicoiniciativas.repositories.IniciativaRepository;

import reactor.core.publisher.Flux;

@Service
public class IniciativaService {

    @Autowired
    IniciativaRepository iniciativaRepository;

    public Flux<Iniciativa> findAll(){
        return iniciativaRepository.findAll();
    }
}
