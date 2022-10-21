package com.receba.iniciativaservice.services;

import com.receba.iniciativaservice.models.Iniciativa;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IniciativaService {

    public Flux<Iniciativa> listAll();

    public Mono<Iniciativa> create(Iniciativa iniciativa);

    public Mono<Iniciativa> update(Iniciativa iniciativa);

    public Mono<Void> delete(String id);
}
