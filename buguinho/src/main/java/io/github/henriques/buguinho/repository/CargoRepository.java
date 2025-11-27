package io.github.henriques.buguinho.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.henriques.buguinho.entity.Cargo;

public interface CargoRepository extends MongoRepository<Cargo, String> {
    
}
