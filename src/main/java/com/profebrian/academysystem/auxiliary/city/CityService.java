package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CityCreateDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import com.profebrian.academysystem.auxiliary.country.Country;
import com.profebrian.academysystem.auxiliary.country.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityService {

    private static final Logger log = LoggerFactory.getLogger(CityService.class);
    private final CityRepository repository;
    private final CityMapper mapper;
    private final CountryService countryService;

    public CityService(CityRepository cityRepository, CityMapper mapper, CountryService countryService) {
        this.repository = cityRepository;
        this.mapper = mapper;
        this.countryService = countryService;
    }

    public CityResponseDTO saveCity(CityCreateDTO cityCreateDTO)
    {
        log.info("[saveCity] Starting with cityCreateDTO: {}", cityCreateDTO);
        var city = mapper.toSaveEntity(cityCreateDTO);
        Country country = countryService.findCountryEntity(cityCreateDTO.countryId());
        city.setCountry(country);
        var savedCity = repository.save(city);
        return mapper.toDTO(savedCity);
    }

    public List<CityResponseDTO> findAllCities() {
        log.info("[findAllCities] Starting:");
        var cities = repository.findAll();
        return mapper.toDTOList(cities);
    }

    public CityResponseDTO findCity(Integer id) {
        log.info("[findCity] Starting with id: {}", id);
        var foundCity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + id));
        return mapper.toDTO(foundCity);
    }

    public void deleteCity(Integer id) {
        log.info("[deleteCity] Starting: ");
        repository.deleteById(id);
    }

    public CityResponseDTO updateCity(CityResponseDTO cityResponseDTO) {
        log.info("[updateCity] Starting with cityResponseDTO: {}: ", cityResponseDTO);
        var city = mapper.toEntity(cityResponseDTO);
        var cityId = city.getCityId();
        if (repository.existsById(cityId)) {
            var updatedCity = repository.save(city);
            return mapper.toDTO(updatedCity);
        } else {
            throw new ResourceNotFoundException("City not found with id: " + cityId);
        }
    }


}
