package com.profebrian.academysystem.auxiliary.country;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository countryRepository) {
        this.repository = countryRepository;
    }

    public Country saveCountry(Country country)
    {
        if (country.getCountryId() == 0){
            country.setCountryId(null);
        } else {
            throw new IllegalArgumentException("Can't save a country when there is a country id");
        }
        return repository.save(country);
    }

    public List<Country> findAllCountries() {
        return repository.findAll();
    }

    public Country findCountryById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }

    public void deleteCountryById(Integer id) {
        repository.deleteById(id);
    }

    public Country updateCountry(Country country) {
        var countryId = country.getCountryId();
        if (countryId != 0 && repository.existsById(countryId)) {
            return repository.save(country);
        } else {
            throw new ResourceNotFoundException("Country not found with id: " + countryId);
        }
    }
}
