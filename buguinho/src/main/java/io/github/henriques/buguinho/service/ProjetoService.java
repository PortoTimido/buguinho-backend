package io.github.henriques.buguinho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.henriques.buguinho.entity.Projeto;
import io.github.henriques.buguinho.repository.ProjetoRepository;

@Service
public class ProjetoService {
    
    @Autowired
    private ProjetoRepository ProjetoRepository;

    /***** LISTA TODOS OS PROJETOS ******/
    public List<Projeto> getAllProjetos() {
        return (ProjetoRepository.findAll());
    }

    /***** LISTA PROJETO POR ID ******/
    public Optional<Projeto> getById(String id) {
        return ProjetoRepository.findById(id);
    }

    /***** INSERE UM NOVO PROJETO ******/
    public Projeto insertProjeto(Projeto Projeto) {
        return ProjetoRepository.save(Projeto);
    }

    /***** ATUALIZA UM PROJETO ******/
    public void updateProjeto(Projeto Projeto, String id) {
        Optional<Projeto> optionalProjeto = ProjetoRepository.findById(id);

        if (optionalProjeto.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto com ID " + id + " não encontrado.");
        }

        Projeto aux = optionalProjeto.get();

        aux.setNome(Projeto.getNome());
        aux.setStatus(Projeto.getStatus());
        aux.setDescricao(Projeto.getDescricao());
        aux.setDataCriacao(Projeto.getDataCriacao());
        aux.setDataFim(Projeto.getDataFim());

        ProjetoRepository.save(aux);
    }

    /***** DELETA UM PROJETO ******/
    public void deleteProjeto(String id) {
        if (ProjetoRepository.existsById(id)) {
            ProjetoRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Projeto não cadastrado.");
        }
    }
}
