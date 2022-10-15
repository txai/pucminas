package com.receba.iniciativaservice.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.receba.iniciativaservice.models.Iniciativa;

@Repository
public interface IniciativaRepository extends ReactiveMongoRepository<Iniciativa, ObjectId> {
}
