package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.country.CountryDTO;

public record CityDTO(Integer cityId,
                      String cityName,
                      CountryDTO countryDTO) {
}
