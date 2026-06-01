package com.distributedsystems.naval.controller;

import com.distributedsystems.naval.models.Ship;
import com.distributedsystems.naval.services.ShipServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Ship", description = "Operações relacionadas aos navios")
public class ShipController {
    private final ShipServices shipServices;

    public ShipController(){
        shipServices = new ShipServices();
    }

    @GetMapping("/ship")
    @Operation(
            summary = "Listar navios",
            description = "Retorna todos os navios cadastrados"
    )
    public List<Ship> getShip(){
        return shipServices.ListShips();
    }

    @PostMapping("/ship")
    @Operation(
            summary = "Cadastrar navio",
            description = "Cria um novo navio no sistema"
    )
    public Ship postShip(@RequestBody String register) {
        return shipServices.CreateShip(register);
    }
}
