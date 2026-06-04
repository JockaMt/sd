package com.distributedsystems.naval.controller;

import com.distributedsystems.naval.dto.CreateCountryDTO;
import com.distributedsystems.naval.dto.UpdateCountryDTO;
import com.distributedsystems.naval.models.Country;
import com.distributedsystems.naval.services.CountryServices;

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
@RequestMapping("/country")
@Tag(name = "Country", description = "Operações relacionadas aos países")
public class CountryController {
    private final CountryServices countryServices;

    public CountryController() {
        this.countryServices = new CountryServices();
    }

    @GetMapping()
    @Operation(
            summary = "Listar países",
            description = "Retorna todos os países cadastrados"
    )
    public List<Country> getCountries() {
        return countryServices.ListCountries();
    }

    @GetMapping("/{code}")
    @Operation(
            summary = "Obter país por código",
            description = "Retorna um país específico com base no código ISO fornecido"
    )
    public Country getCountryByCode(@PathVariable String code) {
        return countryServices.GetCountryByCode(code);
    }

    @PostMapping()
    @Operation(
            summary = "Cadastrar país",
            description = "Cria um novo país no sistema"
    )
    public Country createCountry(@RequestBody CreateCountryDTO dto) {
        return countryServices.CreateCountry(dto);
    }

    @PutMapping("/update/{code}")
    @Operation(
            summary = "Atualizar país",
            description = "Atualiza um país existente"
    )
    public Country updateCountry(@PathVariable String code, @RequestBody UpdateCountryDTO dto) {
        return countryServices.UpdateCountry(code, dto);
    }

    @DeleteMapping("/delete/{code}")
    @Operation(
            summary = "Deletar país",
            description = "Remove um país do sistema"
    )
    public Country deleteCountry(@PathVariable String code) {
        return countryServices.DeleteCountry(code);
    }
}
