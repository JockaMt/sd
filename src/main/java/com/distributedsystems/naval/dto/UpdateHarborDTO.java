package com.distributedsystems.naval.dto;

import java.util.Optional;

public record UpdateHarborDTO(
        Optional<String> newName,
        Optional<String> newLocation
) {}
