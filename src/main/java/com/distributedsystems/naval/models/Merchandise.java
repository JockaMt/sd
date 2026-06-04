package com.distributedsystems.naval.models;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Representação de uma mercadoria transportada por navios.")
public class Merchandise {
    @Schema(description = "Identificador único da mercadoria.")
    private String id;

    @Schema(description = "Nome da mercadoria.")
    private String name;

    @Schema(description = "Descrição da mercadoria.")
    private String description;

    @Schema(description = "Peso em quilogramas.")
    private Double weight;

    public Merchandise(String name, String description, Double weight) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.weight = weight;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
