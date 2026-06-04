package com.distributedsystems.naval.dto;

import java.util.Optional;

public record UpdateCountryDTO (
        Optional<String> newName,
        Optional<String> newCode
) {}
