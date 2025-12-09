package io.github.henriques.buguinho.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.henriques.buguinho.entity.Desenvolvedor;
import io.github.henriques.buguinho.repository.DesenvolvedorRepository;

@Service
public class DesenvolvedorService {

    @Autowired
    private DesenvolvedorRepository desenvolvedorRepository;

    /***** LISTA TODOS OS DESENVOLVEDORES ******/
    public List<Desenvolvedor> getAllDesenvolvedores() {
        return (desenvolvedorRepository.findAll());
    }

    /***** LISTA DESENVOLVEDOR POR ID ******/
    public Optional<Desenvolvedor> getById(String id) {
        return desenvolvedorRepository.findById(id);
    }

    /***** INSERE UM NOVO DESENVOLVEDOR ******/
    public Desenvolvedor insertDesenvolvedor(Desenvolvedor desenvolvedor) {
        return desenvolvedorRepository.save(desenvolvedor);
    }

    /***** ATUALIZA UM DESENVOLVEDOR ******/
    public void updateDesenvolvedor(Desenvolvedor desenvolvedor, String id) {
        Optional<Desenvolvedor> optionalDesenvolvedor = desenvolvedorRepository.findById(id);

        if (optionalDesenvolvedor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Desenvolvedor com ID " + id + " não encontrado.");
        }

        Desenvolvedor aux = optionalDesenvolvedor.get();

        aux.setNome(desenvolvedor.getNome());
        aux.setEmail(desenvolvedor.getEmail());
        aux.setCargo(desenvolvedor.getCargo());

        desenvolvedorRepository.save(aux);
    }

    /***** DELETA UM DESENVOLVEDOR ******/
    public void deleteDesenvolvedor(String id) {
        if (desenvolvedorRepository.existsById(id)) {
            desenvolvedorRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Desenvolvedor não cadastrado.");
        }
    }
}
