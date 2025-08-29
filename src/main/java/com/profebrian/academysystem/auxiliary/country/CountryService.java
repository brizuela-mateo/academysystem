package com.profebrian.academysystem.auxiliary.country;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CountryService {

    private final CountryRepository repository;

    public CountryService(CountryRepository countryRepository, TutorMapper tutorMapper) {
        this.repository = countryRepository;
    }

    public Country saveCountry(Country country)
    {
        return repository.save(country);
    }

    public List<Country> findAllTutors() {
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
        return repository.save(country);
    }

}
