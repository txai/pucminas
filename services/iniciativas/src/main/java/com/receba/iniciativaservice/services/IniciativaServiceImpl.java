package com.receba.iniciativaservice.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receba.iniciativaservice.models.Iniciativa;
import com.receba.iniciativaservice.repositories.IniciativaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IniciativaServiceImpl implements IniciativaService{
    
    @Autowired
    IniciativaRepository iniciativaRepository;

    public Flux<Iniciativa> listAll(){
        return iniciativaRepository.findAll();
    }

    public Mono<Iniciativa> create(Iniciativa iniciativa) {
        return iniciativaRepository.save(iniciativa);
    }

    public Mono<Iniciativa> update(Iniciativa iniciativa) {
        return iniciativaRepository.save(iniciativa);
    }

    public Mono<Void> delete(String id) {
        return iniciativaRepository.deleteById(new ObjectId(id));
    }
}
