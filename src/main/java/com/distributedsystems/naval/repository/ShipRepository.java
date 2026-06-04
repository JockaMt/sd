package com.distributedsystems.naval.repository;

import com.distributedsystems.naval.models.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShipRepository {
    private final List<Ship> shipList = new ArrayList<>();

    public Ship create(Ship ship) {
        shipList.add(ship);
        return ship;
    }

    public List<Ship> findAll() {
        return shipList;
    }

    public Ship findByRegister(String register) {
        return shipList.stream()
            .filter(ship -> Objects.equals(ship.getRegister(), register))
            .findFirst()
            .orElse(null);
    }

    public Ship update(String register, String newRegister) {
        for (int i = 0; i < shipList.size(); i++) {
            if (Objects.equals(shipList.get(i).getRegister(), register)){
                shipList.get(i).setRegister(newRegister);
                return shipList.get(i);
            }
        }
        return null;
    }

    public Ship delete(String register) {
        for (int i = 0; i < shipList.size(); i++) {
            if (Objects.equals(shipList.get(i).getRegister(), register)){
                return shipList.remove(i);
            }
        }
        return null;
    }
}
