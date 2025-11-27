package io.github.henriques.buguinho.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Get, set, equals e hashcode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "desenvolvedores")
public class Desenvolvedor {
    
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    private String nome;
    private String email;
    private Cargo cargo;

}
