package com.profebrian.academysystem.auxiliary.country;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<Country> findById(@PathVariable Integer countryId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findCountryById(countryId));
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllTutors() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCountries());
    }

    @PostMapping
    public ResponseEntity<Country> createTutor(@RequestBody @Valid Country country) {
        var savedCountry = service.saveCountry(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Integer countryId) {
        service.deleteCountryById(countryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping
    ResponseEntity<Country> updateCountry(@RequestBody @Valid Country country) {
        var updatedCountry = service.updateCountry(country);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCountry);
    }
}
