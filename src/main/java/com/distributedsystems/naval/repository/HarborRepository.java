package com.distributedsystems.naval.repository;

import com.distributedsystems.naval.models.Harbor;

import java.util.ArrayList;
import java.util.List;

public class HarborRepository {
    private final List<Harbor> harborList = new ArrayList<Harbor>();

    public void create(Harbor harbor) {
        harborList.add(harbor);
    }

    public List<Harbor> findAll() {
        return harborList;
    }

    public Harbor findByName(String name) {
        return harborList.stream()
            .filter(harbor -> harbor.getName().equals(name))
            .findFirst()
            .orElse(null);
    }

    public Harbor update(String name, String newName, String newLocation) {
        for (int i = 0; i < harborList.size(); i++) {
            if (harborList.get(i).getName().equals(name)){
                if (newName != null) {
                    harborList.get(i).setName(newName);
                }
                if (newLocation != null) {
                    harborList.get(i).setLocation(newLocation);
                }
                return harborList.get(i);
            }
        }
        return null;
    }

    public Harbor delete(String name) {
        for (int i = 0; i < harborList.size(); i++) {
            if (harborList.get(i).getName().equals(name)){
                return harborList.remove(i);
            }
        }
        return null;
    }
}
