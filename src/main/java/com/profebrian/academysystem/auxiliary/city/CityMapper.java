package com.profebrian.academysystem.auxiliary.city;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    City toCity(CityDTO cityDTO);

    CityDTO toCityDTO(City city);

    List<CityDTO> toCityDTOList(List<City> cities);

    List<City> toCityList(List<CityDTO> cityDTOList);
}
