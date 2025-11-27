package io.github.henriques.buguinho.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Serveridade {
    Baixo,
    Alto,
    Médio,
    Crítico
}
