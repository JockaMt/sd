package com.distributedsystems.naval.repository;

import com.distributedsystems.naval.models.Ship;

import java.util.ArrayList;
import java.util.List;

public class ShipRepository {
    private final List<Ship> ships = new ArrayList<>();

    public void save(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> findAll() {
        return ships;
    }
}
