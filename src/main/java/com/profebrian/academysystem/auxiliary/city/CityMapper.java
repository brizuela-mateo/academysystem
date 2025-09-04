package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CityCreateDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityRequestDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(source = "country.countryId", target = "countryId")
    CityResponseDTO toResponseDTO(City city);

    List<CityResponseDTO> toResponseDTO(List<City> cities);

    City toSaveEntity(CityCreateDTO cityCreateDTO);

    City toUpdateEntity(CityRequestDTO cityRequestDTO);
}
