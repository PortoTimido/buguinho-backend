package io.github.henriques.buguinho.service;

import io.github.henriques.buguinho.entity.Bug;
import io.github.henriques.buguinho.repository.BugRepository;

import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BugService {
    
    @Autowired
    private BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public List<Bug> findAll() {
        return bugRepository.findAll();
    }

    public Optional<Bug> findById(String id) {
        return bugRepository.findById(id);
    }

    public Bug create(Bug bug) {      
        bug.setId(null);
        return bugRepository.save(bug);
    }

    public boolean deleteById(String id) {
        if (bugRepository.existsById(id)) {
            bugRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Bug> patch(String id, Map<String, Object> alteracao) {
        return bugRepository.findById(id).map(bug -> {
            if (alteracao.containsKey("titulo")) {
                bug.setTitulo((String) alteracao.get("titulo"));
            }
            if (alteracao.containsKey("projeto")) {
                bug.setProjeto((String) alteracao.get("projeto"));
            }
            if (alteracao.containsKey("descricao")) {
                bug.setDescricao((String) alteracao.get("descricao"));
            }
            if (alteracao.containsKey("severidade")) {
                bug.setSeveridade((String) alteracao.get("severidade"));
            }
            if (alteracao.containsKey("tipo")) {
                bug.setTipo((String) alteracao.get("tipo"));
            }
            if (alteracao.containsKey("status")) {
                bug.setStatus((String) alteracao.get("status"));
            }
            if (alteracao.containsKey("desenvolvedorResponsavel")) {
                bug.setDesenvolvedorResponsavel((String) alteracao.get("desenvolvedorResponsavel"));
            }
            if (alteracao.containsKey("dataIdentificacao")) {
                Object v = alteracao.get("dataIdentificacao");
                if (v instanceof String) {
                    bug.setDataIdentificacao(Instant.parse((String) v));
                }
            }

            return bugRepository.save(bug);
        });
    }

}
