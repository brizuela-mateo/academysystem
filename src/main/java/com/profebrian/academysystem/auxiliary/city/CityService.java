package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CitySaveDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityRequestDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import com.profebrian.academysystem.auxiliary.country.Country;
import com.profebrian.academysystem.auxiliary.country.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public CityResponseDTO saveCity(CitySaveDTO citySaveDTO) {
        log.debug("[saveCity] Starting with: {}", citySaveDTO);
        var city = mapper.toSaveEntity(citySaveDTO);
        Country country = countryService.findCountryEntity(citySaveDTO.countryId());
        city.setCountry(country);
        var savedCity = repository.save(city);
        return mapper.toResponseDTO(savedCity);
    }

    public List<CityResponseDTO> findAllCities() {
        log.debug("[findAllCities] Starting: ");
        var cities = repository.findAll();
        return mapper.toResponseDTO(cities);
    }

    public CityResponseDTO findCity(Integer id) {
        log.debug("[findCity] Starting with Id: {}", id);
        var foundCity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + id));
        return mapper.toResponseDTO(foundCity);
    }

    @Transactional
    public void deleteCity(Integer id) {
        log.debug("[deleteCity] Starting with Id: {}", id);
        repository.deleteById(id);
    }

    @Transactional
    public CityResponseDTO updateCity(CityRequestDTO cityRequestDTO) {
        log.debug("[updateCity] Starting with: {}: ", cityRequestDTO);
        Country country = countryService.findCountryEntity(cityRequestDTO.countryId());
        var city = mapper.toUpdateEntity(cityRequestDTO);
        var cityId = city.getCityId();
        if (repository.existsById(cityId)) {
            city.setCountry(country);
            var updatedCity = repository.save(city);
            return mapper.toResponseDTO(updatedCity);
        } else {
            throw new ResourceNotFoundException("City not found with id: " + cityId);
        }
    }


}
