package com.receba.servicoiniciativas.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Value;

@Value
@Document
public class Iniciativa {

    @Id ObjectId id;

    String nome;

    Date dataDistribuicao;

    int userId;
}
