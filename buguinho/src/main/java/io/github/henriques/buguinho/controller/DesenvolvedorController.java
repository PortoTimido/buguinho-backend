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

import io.github.henriques.buguinho.entity.Desenvolvedor;
import io.github.henriques.buguinho.service.DesenvolvedorService;

@CrossOrigin
@RestController
@RequestMapping("/desenvolvedores")
public class DesenvolvedorController {
    
    @Autowired 
    private DesenvolvedorService desenvolvedorService;

    @GetMapping
    public ResponseEntity<List<Desenvolvedor>> getAll() {
        return ResponseEntity.ok(desenvolvedorService.getAllDesenvolvedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desenvolvedor> getById(@PathVariable String id) {
        return desenvolvedorService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Desenvolvedor> insert(@RequestBody Desenvolvedor desenvolvedor) {
        return ResponseEntity.created(null).body(desenvolvedorService.insertDesenvolvedor(desenvolvedor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void>delete(@PathVariable String id) {
        desenvolvedorService.deleteDesenvolvedor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody Desenvolvedor desenvolvedor) {
        desenvolvedorService.updateDesenvolvedor(desenvolvedor, id);
        return ResponseEntity.noContent().build();
    }

}
