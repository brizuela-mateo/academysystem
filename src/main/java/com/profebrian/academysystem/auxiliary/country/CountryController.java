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
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable Integer countryId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findCountry(countryId));
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCountries());
    }

    @PostMapping
    public ResponseEntity<CountryDTO> postCreateCountry(@RequestBody @Valid CountryDTO countryDTO) {
        var savedCountry = service.createCountry(countryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Integer countryId) {
        service.deleteCountry(countryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping
    ResponseEntity<CountryDTO> patchUpdateCountry(@RequestBody @Valid CountryDTO countryDTO) {
        var updatedCountry = service.updateCountry(countryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCountry);
    }
}
