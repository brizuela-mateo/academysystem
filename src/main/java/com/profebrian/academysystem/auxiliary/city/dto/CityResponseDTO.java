package com.profebrian.academysystem.auxiliary.city.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CityResponseDTO(@NotNull
                              Integer cityId,
                              @NotNull @Size(max = 100)
                              String cityName,
                              @NotNull
                              Integer countryId) {
}
