package com.receba.iniciativaservice.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

public class ExtendedIniciativaRepositoryImpl implements ExtendedIniciativaRepository{
    
    private final ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public ExtendedIniciativaRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
