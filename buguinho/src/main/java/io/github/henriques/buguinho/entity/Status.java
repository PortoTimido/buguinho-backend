package io.github.henriques.buguinho.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Status {
    Aberto,
    Em_Progresso,
    Resolvido,
    Fechado
}
