package com.receba.iniciativaservice.models;

import java.util.Map;

import lombok.Value;

@Value
public class IniciativaDTO {
    String id;

    String nome;

    String dataDistribuicao;

    String endereco;

    String telefone;

    String email;

    Map<String, Integer> composicaoCesta;

    int userId;
}
