package com.distributedsystems.naval.models;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Representação de um país onde navios podem navegar e realizar comércio.")
public class Country {
    @Schema(description = "Identificador único do país.")
    private String id;

    @Schema(description = "Nome do país.")
    private String name;

    @Schema(description = "Código ISO 3166-1 alpha-2 do país.")
    private String code;

    public Country(String name, String code) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
