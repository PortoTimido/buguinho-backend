package io.github.henriques.buguinho.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bugs")
public class Bugs {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String titulo;
    private String projeto;
    private String descricao;
    private String severidade; // baixo, alto, médio ou crítico
    private String tipo;
    private Instant dataIdentificacao;
    private String status; // aberto, em progresso, resolvido, fechado
    private String desenvolvedorResponsavel;
}