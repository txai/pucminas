package com.receba.iniciativaservice.services;

import org.springframework.stereotype.Service;

import com.receba.iniciativaservice.models.Iniciativa;

import reactor.core.publisher.Flux;

@Service
public interface IniciativaService {

    public Flux<Iniciativa> findAll();
}
