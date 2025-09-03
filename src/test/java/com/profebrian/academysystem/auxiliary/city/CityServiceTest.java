package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CityCreateDTO;
import com.profebrian.academysystem.auxiliary.country.Country;
import com.profebrian.academysystem.auxiliary.country.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @InjectMocks
    private CityService service;
    @Mock
    private CountryService countryService;
    @Mock
    private CityRepository repository;

    CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    @BeforeEach
    void before(){
        ReflectionTestUtils.setField(service, "mapper", cityMapper);
    }


    @Test
    void saveCity() {
        var cityCreateDTO = new CityCreateDTO("cityTest", 1);
        var country = new Country();
        country.setCountryId(1);
        country.setCountryName("countryTest");
        country.setCountryCode("CT");
        when(countryService.findCountryEntity(cityCreateDTO.countryId()))
                .thenReturn(country);
        var city = new City();
        city.setCityId(1);
        city.setCityName("cityTest");
        city.setCountry(country);
        when(repository.save(any(City.class))).thenReturn(city);
        var cityResponse = service.saveCity(cityCreateDTO);
        assertEquals(city.getCityId(),cityResponse.cityId());
    }

    @Test
    void findAllCities() {
    }

    @Test
    void findCity() {
    }

    @Test
    void deleteCity() {
    }

    @Test
    void updateCity() {
    }
}