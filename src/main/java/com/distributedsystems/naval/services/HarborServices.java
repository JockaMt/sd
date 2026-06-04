package com.distributedsystems.naval.services;

import com.distributedsystems.naval.dto.CreateHarborDTO;
import com.distributedsystems.naval.dto.UpdateHarborDTO;
import com.distributedsystems.naval.models.Harbor;
import com.distributedsystems.naval.repository.HarborRepository;

import java.util.List;

public class HarborServices {
    public final HarborRepository repository;

    public HarborServices () {
        this.repository = new HarborRepository();
    }

    public Harbor CreateHarbor (CreateHarborDTO dto) {
        Harbor harbor = new Harbor(dto.name(), dto.location());
        repository.create(harbor);
        return harbor;
    }

    public List<Harbor> ListHarbors () {
        return repository.findAll();
    }

    public Harbor GetHarborByName (String name) {
        return repository.findByName(name);
    }

    public Harbor UpdateHarbor (String name, UpdateHarborDTO dto) {
        return repository.update(name, dto.newName().orElse(null), dto.newLocation().orElse(null));
    }

    public Harbor DeleteHarbor (String name) {
        return repository.delete(name);
    }
}