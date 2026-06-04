package com.distributedsystems.naval.controller;

import com.distributedsystems.naval.dto.CreateHarborDTO;
import com.distributedsystems.naval.dto.UpdateHarborDTO;
import com.distributedsystems.naval.models.Harbor;
import com.distributedsystems.naval.services.HarborServices;

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
@RequestMapping("/harbor")
@Tag(name = "Harbor", description = "Operações relacionadas aos portos")
public class HarborController {
    private final HarborServices harborServices;

    public HarborController() { this.harborServices = new HarborServices(); }

    @GetMapping()
    @Operation(
            summary = "Listar portos",
            description = "Retorna todos os portos cadastrados"
    )
    public List<Harbor> getHarbor(){
        return harborServices.ListHarbors();
    }

    @GetMapping("/{name}")
    @Operation(
            summary = "Obter porto por nome",
            description = "Retorna um porto específico com base no nome fornecido"
    )
    public Harbor getHarborByName(@PathVariable String name) {
        return harborServices.GetHarborByName(name);
    }

    @PostMapping()
    @Operation(
            summary = "Cadastrar porto",
            description = "Cria um novo porto no sistema"
    )
    public Harbor postHarbor(@RequestBody CreateHarborDTO dto) {
        return harborServices.CreateHarbor(dto);
    }

    @DeleteMapping("/delete/{name}")
    @Operation(
            summary = "Deletar porto por nome",
            description = "Deleta um porto específico com base no nome fornecido"
    )
    public Harbor deleteHarborByName(@PathVariable String name) {
        return harborServices.DeleteHarbor(name);
    }

    @PutMapping("/update/{name}")
    @Operation(
            summary = "Atualizar porto por nome",
            description = "Atualiza um porto específico com base no nome fornecido"
    )
    public Harbor updateHarborByName(@PathVariable String name, @RequestBody UpdateHarborDTO dto) {
        return harborServices.UpdateHarbor(name, dto);
    }
}
