package com.profebrian.academysystem.auxiliary.country;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toCountry(CountryDTO countryDTO);

    CountryDTO toCountryDTO(Country country);

    List<CountryDTO> toCountryDTOList(List<Country> countries);

    List<Country> toCountryList(List<CountryDTO> countryDTOList);
}
