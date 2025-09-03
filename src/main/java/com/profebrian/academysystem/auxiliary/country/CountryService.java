package com.profebrian.academysystem.auxiliary.country;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    private final CountryRepository repository;

    private final CountryMapper mapper;

    public CountryService(CountryRepository countryRepository, CountryMapper mapper) {
        this.repository = countryRepository;
        this.mapper = mapper;
    }

    public CountryDTO createCountry(CountryDTO countryDTO)
    {
        Country country = mapper.toCountry(countryDTO);
        if (country.getCountryId() == 0){
            country.setCountryId(null);
        } else {
            throw new IllegalArgumentException("Can't save a country when there is a country id");
        }
        var createdCountry = repository.save(country);
        return mapper.toCountryDTO(createdCountry);
    }

    public List<CountryDTO> findAllCountries() {
        var countries = repository.findAll();
        return mapper.toCountryDTOList(countries);
    }

    public CountryDTO findCountry(Integer id) {
        var foundCountry = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        return mapper.toCountryDTO(foundCountry);
    }

    public void deleteCountry(Integer id) {
        repository.deleteById(id);
    }

    public CountryDTO updateCountry(CountryDTO countryDTO) {
        var country = mapper.toCountry(countryDTO);
        var countryId = country.getCountryId();
        if (countryId != 0 && repository.existsById(countryId)) {
            var updatedCountry = repository.save(country);
            return mapper.toCountryDTO(updatedCountry);
        } else {
            throw new ResourceNotFoundException("Country not found with id: " + countryId);
        }
    }

    public Country findCountryEntity(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }
}
