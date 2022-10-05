package com.receba.servicoiniciativas.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Value;

@Value
@Document("iniciativas")
public class Iniciativa {

    @Id String id;

    String nome;

    Date dataDistribuicao;

    int userId;
}
