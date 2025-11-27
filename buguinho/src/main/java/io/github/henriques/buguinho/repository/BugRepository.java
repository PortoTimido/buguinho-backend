package io.github.henriques.buguinho.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.github.henriques.buguinho.entity.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {
    List<Bug> findByProjeto(String projeto);
    List<Bug> findByTipo(String tipo);
    List<Bug> findByDesenvolvedorResponsavel(String dev);
    List<Bug> findBySeveridade(String severidade);
}
