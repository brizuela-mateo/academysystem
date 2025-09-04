package com.profebrian.academysystem.auxiliary.country.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CountryRequestDTO(@NotNull
                                Integer countryId,
                                @NotNull @Size(max = 60)
                                String countryName,
                                @NotNull @Size(max = 5)
                                String countryCode) {
}
