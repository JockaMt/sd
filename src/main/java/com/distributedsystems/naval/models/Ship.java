package com.distributedsystems.naval.models;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Representa um navio")
public class Ship {
    @Schema(
            description = "Identificador único",
            example = "550e8400-e29b-41d4-a716-446655440000"
    )
    private final String id;
    @Schema(
            description = "Registro oficial do navio",
            example = "BR12345"
    )
    private String register;
    //private routeID RouteID;

    public Ship(String Register){
        this.id = UUID.randomUUID().toString();
        this.register = Register;
    }

    public String getId() {
        return id;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String newRegister) {
        this.register = newRegister;
    }
}