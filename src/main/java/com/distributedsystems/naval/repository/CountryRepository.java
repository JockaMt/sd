package com.distributedsystems.naval.repository;

import com.distributedsystems.naval.models.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryRepository {
    private final List<Country> countryList = new ArrayList<Country>();

    public void create(Country country) {
        countryList.add(country);
    }

    public List<Country> findAll() {
        return countryList;
    }

    public Country findByCode(String code) {
        return countryList.stream()
            .filter(country -> country.getCode().equals(code))
            .findFirst()
            .orElse(null);
    }

    public Country update(String code, String newName, String newCode) {
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getCode().equals(code)){
                if (newName != null) {
                    countryList.get(i).setName(newName);
                }
                if (newCode != null) {
                    countryList.get(i).setCode(newCode);
                }
                return countryList.get(i);
            }
        }
        return null;
    }

    public Country delete(String code) {
        for (int i = 0; i < countryList.size(); i++) {
            if (countryList.get(i).getCode().equals(code)){
                return countryList.remove(i);
            }
        }
        return null;
    }
}
