package io.github.henriques.buguinho.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.henriques.buguinho.entity.Desenvolvedor;

public interface DesenvolvedorRepository extends MongoRepository<Desenvolvedor, String> {

}
