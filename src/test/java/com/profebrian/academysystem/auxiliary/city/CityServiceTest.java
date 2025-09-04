package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CityCreateDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityRequestDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import com.profebrian.academysystem.auxiliary.country.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityServiceTest {

    @InjectMocks
    private CityService service;
    @Mock
    private CityRepository repository;

    CityMapper cityMapper = Mappers.getMapper(CityMapper.class);

    @BeforeEach
    void before(){
        ReflectionTestUtils.setField(service, "mapper", cityMapper);
    }


    @Test
    void testSaveCity() {
        System.out.println("testSaveCity");
        var cityCreateDTO = new CityCreateDTO("cityTest", 1);
        var city = createCity();
        when(repository.save(any(City.class))).thenReturn(city);
        var cityResponse = service.saveCity(cityCreateDTO);
        assertEquals(city.getCityId(),cityResponse.cityId());
    }

    @Test
    void testFindAllCities() {
        System.out.println("testFindAllCities");
        service.findAllCities();
        var city = createCity();
        when(repository.findAll()).thenReturn(List.of(city));
        var cityResponseDTOSList = service.findAllCities();
        assertEquals(cityResponseDTOSList.getFirst().cityId(), city.getCityId());
    }

    @Test
    void testFindCity() {
        System.out.println("testFindCity");
        var city = createCity();
        when(repository.findById(city.getCityId())).thenReturn(Optional.of(city));
        var cityResponseDTO = service.findCity(city.getCityId());
        assertEquals(cityResponseDTO.cityId(), city.getCityId());
    }

    @Test
    void testDeleteCity() {
        System.out.println("testDeleteCity");
        service.deleteCity(1);
        verify(repository, times(1)).deleteById(1);
    }

    @Test
    void testUpdateCity() {
        System.out.println("testUpdateCity");
        var city = createCity();
        var cityRequestDTO = new CityRequestDTO(1,"cityTest", 1);
        when(repository.existsById(cityRequestDTO.cityId())).thenReturn(true);
        when(repository.save(any(City.class))).thenReturn(city);
        var cityResponseDTO = service.updateCity(cityRequestDTO);
        assertEquals(city.getCityId(),cityResponseDTO.cityId());
    }

    private City createCity(){
        var country = new Country();
        country.setCountryId(1);
        country.setCountryName("countryTest");
        country.setCountryCode("CT");

        var city = new City();
        city.setCityId(1);
        city.setCityName("cityTest");
        city.setCountry(country);
        return city;
    }
}