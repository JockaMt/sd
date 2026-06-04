package com.distributedsystems.naval.services;

import com.distributedsystems.naval.dto.CreateMerchandiseDTO;
import com.distributedsystems.naval.dto.UpdateMerchandiseDTO;
import com.distributedsystems.naval.models.Merchandise;
import com.distributedsystems.naval.repository.MerchandiseRepository;

import java.util.List;

public class MerchandiseServices {
    public final MerchandiseRepository repository;

    public MerchandiseServices() {
        this.repository = new MerchandiseRepository();
    }

    public Merchandise CreateMerchandise(CreateMerchandiseDTO dto) {
        Merchandise merchandise = new Merchandise(dto.name(), dto.description(), dto.weight());
        repository.create(merchandise);
        return merchandise;
    }

    public List<Merchandise> ListMerchandises() {
        return repository.findAll();
    }

    public Merchandise GetMerchandiseByName(String name) {
        return repository.findByName(name);
    }

    public Merchandise UpdateMerchandise(String name, UpdateMerchandiseDTO dto) {
        return repository.update(name, dto.newName().orElse(null), dto.newDescription().orElse(null), dto.newWeight().orElse(null));
    }

    public Merchandise DeleteMerchandise(String name) {
        return repository.delete(name);
    }
}
