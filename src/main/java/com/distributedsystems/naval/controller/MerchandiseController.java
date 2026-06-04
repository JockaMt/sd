package com.distributedsystems.naval.controller;

import com.distributedsystems.naval.dto.CreateMerchandiseDTO;
import com.distributedsystems.naval.dto.UpdateMerchandiseDTO;
import com.distributedsystems.naval.models.Merchandise;
import com.distributedsystems.naval.services.MerchandiseServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/merchandise")
@Tag(name = "Merchandise", description = "Operações relacionadas às mercadorias")
public class MerchandiseController {
    private final MerchandiseServices merchandiseServices;

    public MerchandiseController() {
        this.merchandiseServices = new MerchandiseServices();
    }

    @GetMapping()
    @Operation(
            summary = "Listar mercadorias",
            description = "Retorna todas as mercadorias cadastradas"
    )
    public List<Merchandise> getMerchandises() {
        return merchandiseServices.ListMerchandises();
    }

    @GetMapping("/{name}")
    @Operation(
            summary = "Obter mercadoria por nome",
            description = "Retorna uma mercadoria específica com base no nome fornecido"
    )
    public Merchandise getMerchandiseByName(@PathVariable String name) {
        return merchandiseServices.GetMerchandiseByName(name);
    }

    @PostMapping()
    @Operation(
            summary = "Cadastrar mercadoria",
            description = "Cria uma nova mercadoria no sistema"
    )
    public Merchandise createMerchandise(@RequestBody CreateMerchandiseDTO dto) {
        return merchandiseServices.CreateMerchandise(dto);
    }

    @PutMapping("/update/{name}")
    @Operation(
            summary = "Atualizar mercadoria",
            description = "Atualiza uma mercadoria existente"
    )
    public Merchandise updateMerchandise(@PathVariable String name, @RequestBody UpdateMerchandiseDTO dto) {
        return merchandiseServices.UpdateMerchandise(name, dto);
    }

    @DeleteMapping("/delete/{name}")
    @Operation(
            summary = "Deletar mercadoria",
            description = "Remove uma mercadoria do sistema"
    )
    public Merchandise deleteMerchandise(@PathVariable String name) {
        return merchandiseServices.DeleteMerchandise(name);
    }
}
