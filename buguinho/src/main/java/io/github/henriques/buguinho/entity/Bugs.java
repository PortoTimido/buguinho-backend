package io.github.henriques.buguinho.entity;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bugs")
public class Bugs {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String projeto;
    private String descricao;
    private String severidade;
    private String tipo;
    private LocalDate dataIdentificacao;
    private String status;
    private String desenvolvedorResponsavel;
}