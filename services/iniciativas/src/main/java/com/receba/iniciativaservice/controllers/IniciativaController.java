package com.receba.iniciativaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receba.iniciativaservice.models.IniciativaDTO;
import com.receba.iniciativaservice.services.IniciativaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/iniciativas")
public class IniciativaController {
    
    @Autowired
    IniciativaService iniciativaService;

    @GetMapping
    public Flux<IniciativaDTO> listAll() {
        return iniciativaService.listAll().map(i -> new IniciativaDTO(i));
    }

    @PostMapping
    public Mono<IniciativaDTO> create(@RequestBody IniciativaDTO iniciativa) {
        return iniciativaService.create(iniciativa.toIniciativa()).map(i -> new IniciativaDTO(i));
    }

    @PutMapping("{id}")
    public Mono<IniciativaDTO> update(@PathVariable String id, @RequestBody IniciativaDTO iniciativa) {
        iniciativa.setId(id);
        return iniciativaService.update(iniciativa.toIniciativa()).map(i -> new IniciativaDTO(i));
    }

    @DeleteMapping("{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return iniciativaService.delete(id);
    }
}
