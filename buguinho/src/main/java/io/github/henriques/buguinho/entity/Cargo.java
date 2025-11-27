package io.github.henriques.buguinho.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Get, set, equals e hashcode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "cargos")
public class Cargo {

    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    @Field("nome")
    private String nome;

}