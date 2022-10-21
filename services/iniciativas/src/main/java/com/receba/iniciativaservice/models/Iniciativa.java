package com.receba.iniciativaservice.models;

import java.time.LocalDate;
import java.util.Stack;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@Document
public class Iniciativa {

    @NonFinal @Id String id;

    String nome;

    LocalDate dataDistribuicao;

    String endereco;

    String telefone;

    String email;

    Stack<CestaBasica> cestas = new Stack<>();

    ComposicaoCestaBasica composicaoCesta;

    String userId;

    @PersistenceCreator
    public Iniciativa(String id, String nome, LocalDate dataDistribuicao, String endereco, String telefone, String email, Stack<CestaBasica> cestas, ComposicaoCestaBasica composicaoCesta, String userId) {
        this.id = id;
        this.nome = nome;
        this.dataDistribuicao = dataDistribuicao;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        cestas.addAll(cestas);
        this.composicaoCesta = composicaoCesta;
        this.userId = userId;
    }
}
