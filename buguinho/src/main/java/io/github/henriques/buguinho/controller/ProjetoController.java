package io.github.henriques.buguinho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.henriques.buguinho.entity.Projeto;
import io.github.henriques.buguinho.service.ProjetoService;

@CrossOrigin
@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired 
    private ProjetoService ProjetoService;

    @GetMapping
    public ResponseEntity<List<Projeto>> getAll() {
        return ResponseEntity.ok(ProjetoService.getAllProjetos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> getById(@PathVariable String id) {
        return ProjetoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Projeto> insert(@RequestBody Projeto Projeto) {
        return ResponseEntity.created(null).body(ProjetoService.insertProjeto(Projeto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable String id) {
        ProjetoService.deleteProjeto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Projeto Projeto) {
        ProjetoService.updateProjeto(Projeto, id);
        return ResponseEntity.noContent().build();
    }
}
