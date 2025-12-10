package io.github.henriques.buguinho.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Cargo {
    Desenvolvedor_FrontEnd("Desenvolvedor FrontEnd"),
    Desenvolvedor_BackEnd("Desenvolvedor BackEnd"),
    Testador("Testador"),
    Dba("DBA");

    private final String displayName;

    Cargo(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}