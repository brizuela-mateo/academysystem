package com.profebrian.academysystem.auxiliary.country;

import com.profebrian.academysystem.auxiliary.country.dto.CountryResponseDTO;
import com.profebrian.academysystem.auxiliary.country.dto.CountryRequestDTO;
import com.profebrian.academysystem.auxiliary.country.dto.CountrySaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    Country toCountry(CountryResponseDTO countryResponseDTO);

    CountryResponseDTO toCountryDTO(Country country);

    List<CountryResponseDTO> toCountryDTOList(List<Country> countries);

    List<Country> toCountryList(List<CountryResponseDTO> countryResponseDTOList);

    Country toSaveEntity(CountrySaveDTO countrySaveDTO);

    Country toUpdateEntity(CountryRequestDTO countryRequestDTO);
}
