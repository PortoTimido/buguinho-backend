package io.github.henriques.buguinho.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.henriques.buguinho.entity.Bugs;

public interface BugRepository extends MongoRepository<Bugs, String> {
    List<Bugs> findByProjeto(String projeto);
    List<Bugs> findByTipo(String tipo);
    List<Bugs> findByDesenvolvedorResponsavel(String dev);
    List<Bugs> findBySeveridade(String severidade);
}
