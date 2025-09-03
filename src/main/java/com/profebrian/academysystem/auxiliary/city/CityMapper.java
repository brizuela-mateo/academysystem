package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CityCreateDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City toEntity(CityResponseDTO cityResponseDTO);

    @Mapping(source = "country.countryId", target = "countryId")
    CityResponseDTO toDTO(City city);

    List<CityResponseDTO> toDTOList(List<City> cities);

    City toSaveEntity(CityCreateDTO cityCreateDTO);
}
