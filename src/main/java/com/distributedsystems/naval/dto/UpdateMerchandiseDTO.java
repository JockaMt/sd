package com.distributedsystems.naval.dto;

import java.util.Optional;

public record UpdateMerchandiseDTO (
        Optional<String> newName,
        Optional<String> newDescription,
        Optional<Double> newWeight
) {}
