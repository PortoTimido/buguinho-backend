package io.github.henriques.buguinho.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.henriques.buguinho.entity.Projeto;

public interface ProjetoRepository extends MongoRepository<Projeto, String> {
    
}
