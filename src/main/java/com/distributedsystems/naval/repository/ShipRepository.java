package com.distributedsystems.naval.repository;

import com.distributedsystems.naval.models.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShipRepository {
    private final List<Ship> ships = new ArrayList<>();

    public void save(Ship ship) {
        ships.add(ship);
    }

    public List<Ship> findAll() {
        return ships;
    }

    public Ship update(String register, String newRegister) {
        for (int i = 0; i < ships.size(); i++) {
            if (Objects.equals(ships.get(i).getRegister(), register)){
                ships.get(i).setRegister(newRegister);
                return ships.get(i);
            }
        }
        return null;
    }

    public Ship delete(String register) {
        for (int i = 0; i < ships.size(); i++) {
            if (Objects.equals(ships.get(i).getRegister(), register)){
                return ships.remove(i);
            }
        }
        return null;
    }
}
