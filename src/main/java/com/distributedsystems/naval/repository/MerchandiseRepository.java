package com.distributedsystems.naval.repository;

import com.distributedsystems.naval.models.Merchandise;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseRepository {
    private final List<Merchandise> merchandiseList = new ArrayList<Merchandise>();

    public void create(Merchandise merchandise) {
        merchandiseList.add(merchandise);
    }

    public List<Merchandise> findAll() {
        return merchandiseList;
    }

    public Merchandise findByName(String name) {
        return merchandiseList.stream()
            .filter(merchandise -> merchandise.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public Merchandise update(String name, String newName, String newDescription, Double newWeight) {
        for (int i = 0; i < merchandiseList.size(); i++) {
            if (merchandiseList.get(i).getName().equals(name)){
                if (newName != null) {
                    merchandiseList.get(i).setName(newName);
                }
                if (newDescription != null) {
                    merchandiseList.get(i).setDescription(newDescription);
                }
                if (newWeight != null) {
                    merchandiseList.get(i).setWeight(newWeight);
                }
                return merchandiseList.get(i);
            }
        }
        return null;
    }

    public Merchandise delete(String name) {
        for (int i = 0; i < merchandiseList.size(); i++) {
            if (merchandiseList.get(i).getName().equals(name)){
                return merchandiseList.remove(i);
            }
        }
        return null;
    }
}
