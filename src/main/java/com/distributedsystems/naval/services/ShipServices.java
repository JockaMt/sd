package com.distributedsystems.naval.services;

import com.distributedsystems.naval.models.Ship;
import com.distributedsystems.naval.repository.ShipRepository;

import java.util.List;

public class ShipServices {
    public final ShipRepository repository;

    public ShipServices () {
        this.repository = new ShipRepository();
    }

    public Ship CreateShip (String register) {
        Ship ship = new Ship(register);
        repository.create(ship);
        return ship;
    }

    public List<Ship> ListShips () {
        return repository.findAll();
    }

    public Ship GetShipByRegister (String register) {
        return repository.findByRegister(register);
    }

    public Ship UpdateShip (String register, String newRegister) {
        return repository.update(register, newRegister);
    }

    public Ship DeleteShip (String register) {
        return repository.delete(register);
    }
}
