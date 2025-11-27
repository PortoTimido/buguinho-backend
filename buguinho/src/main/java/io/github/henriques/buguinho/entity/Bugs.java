package io.github.henriques.buguinho.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bugs")
public class Bugs {

    @Id
    private String id;

    private String projeto;
    private String descricao;
    private String severidade;
    private String tipo;
    private LocalDate dataIdentificacao;
    private String status;
    private String desenvolvedorResponsavel;
}