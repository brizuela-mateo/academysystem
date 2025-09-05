package com.profebrian.academysystem.auxiliary.country;

import com.profebrian.academysystem.auxiliary.country.dto.CountryResponseDTO;
import com.profebrian.academysystem.auxiliary.country.dto.CountryRequestDTO;
import com.profebrian.academysystem.auxiliary.country.dto.CountrySaveDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CountryService {

    private static final Logger log = LoggerFactory.getLogger(CountryService.class);

    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryService(CountryRepository countryRepository, CountryMapper mapper) {
        this.repository = countryRepository;
        this.mapper = mapper;
    }

    @Transactional
    public CountryResponseDTO saveCountry(CountrySaveDTO countrySaveDTO) {
        log.debug("[saveCountry] Starting with: {}", countrySaveDTO);
        Country country = mapper.toSaveEntity(countrySaveDTO);
        var savedCountry = repository.save(country);
        return mapper.toCountryDTO(savedCountry);
    }

    public List<CountryResponseDTO> findAllCountries() {
        log.debug("[findAllCountries] Starting: ");
        var countries = repository.findAll();
        return mapper.toCountryDTOList(countries);
    }

    public CountryResponseDTO findCountry(Integer id) {
        log.debug("[findCountry] Starting with id: {}: ", id);
        var foundCountry = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        return mapper.toCountryDTO(foundCountry);
    }

    @Transactional
    public void deleteCountry(Integer id) {
        log.debug("[deleteCountry] Starting with id: {}: ", id);
        repository.deleteById(id);
    }

    @Transactional
    public CountryResponseDTO updateCountry(CountryRequestDTO countryRequestDTO) {
        log.debug("[updateCountry] Starting with: {}: ", countryRequestDTO);
        var country = mapper.toUpdateEntity(countryRequestDTO);
        var countryId = country.getCountryId();
        if (repository.existsById(countryId)) {
            var updatedCountry = repository.save(country);
            return mapper.toCountryDTO(updatedCountry);
        } else {
            throw new ResourceNotFoundException("Country not found with id: " + countryId);
        }
    }

    public Country findCountryEntity(Integer id) {
        log.debug("[findCountryEntity] Starting with: {}: ", id);
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }
}
