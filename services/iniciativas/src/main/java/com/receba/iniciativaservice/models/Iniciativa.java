package com.receba.iniciativaservice.models;

import java.util.Date;
import java.util.Stack;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@Document("iniciativas")
public class Iniciativa {

    @NonFinal @Id String id;

    String nome;

    Date dataDistribuicao;

    String endereco;

    String telefone;

    String email;

    Stack<CestaBasica> cestas = new Stack<>();

    ComposicaoCestaBasica composicaoCesta;

    int userId;
}
