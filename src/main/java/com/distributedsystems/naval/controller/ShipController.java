package com.distributedsystems.naval.controller;

import com.distributedsystems.naval.models.CreateShipDTO;
import com.distributedsystems.naval.models.Ship;
import com.distributedsystems.naval.models.UpdateShipDTO;
import com.distributedsystems.naval.services.ShipServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ship")
@Tag(name = "Ship", description = "Operações relacionadas aos navios")
public class ShipController {
    private final ShipServices shipServices;

    public ShipController(){
        shipServices = new ShipServices();
    }

    @GetMapping()
    @Operation(
            summary = "Listar navios",
            description = "Retorna todos os navios cadastrados"
    )
    public List<Ship> getShip(){
        return shipServices.ListShips();
    }

    @PostMapping()
    @Operation(
            summary = "Cadastrar navio",
            description = "Cria um novo navio no sistema"
    )
    public Ship postShip(@RequestBody CreateShipDTO dto) {
        return shipServices.CreateShip(dto.register());
    }

    @PutMapping("/{register}")
    @Operation(
            summary = "Atualiza navio",
            description = "Atualiza navio identificado pelo registro"
    )
    public Ship updateShip(@PathVariable String register, @RequestBody UpdateShipDTO dto) {
        return shipServices.UpdateShip(register, dto.newRegister());
    }

    @DeleteMapping("/{register}")
    public Ship deleteShip(@PathVariable String register) {
        return shipServices.DeleteShip(register);
    }
}
