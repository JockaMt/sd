package com.distributedsystems.naval.services;

import com.distributedsystems.naval.dto.CreateCountryDTO;
import com.distributedsystems.naval.dto.UpdateCountryDTO;
import com.distributedsystems.naval.models.Country;
import com.distributedsystems.naval.repository.CountryRepository;

import java.util.List;

public class CountryServices {
    public final CountryRepository repository;

    public CountryServices() {
        this.repository = new CountryRepository();
    }

    public Country CreateCountry(CreateCountryDTO dto) {
        Country country = new Country(dto.name(), dto.code());
        repository.create(country);
        return country;
    }

    public List<Country> ListCountries() {
        return repository.findAll();
    }

    public Country GetCountryByCode(String code) {
        return repository.findByCode(code);
    }

    public Country UpdateCountry(String code, UpdateCountryDTO dto) {
        return repository.update(code, dto.newName().orElse(null), dto.newCode().orElse(null));
    }

    public Country DeleteCountry(String code) {
        return repository.delete(code);
    }
}
