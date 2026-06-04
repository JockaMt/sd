package com.distributedsystems.naval.models;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "Representação de um porto, onde os navios podem atracar e realizar operações de carga e descarga.")
public class Harbor {
    @Schema(description = "Identificador único do porto.")
    private String id;

    @Schema(description = "Nome do porto.")
    private String name;

    @Schema(description = "Localização geográfica do porto.")
    private String location;

    public Harbor(String name, String location) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
