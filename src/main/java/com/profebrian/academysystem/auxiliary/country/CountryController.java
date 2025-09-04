package com.profebrian.academysystem.auxiliary.country;

import com.profebrian.academysystem.auxiliary.country.dto.CountryResponseDTO;
import com.profebrian.academysystem.auxiliary.country.dto.CountryRequestDTO;
import com.profebrian.academysystem.auxiliary.country.dto.CountrySaveDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<CountryResponseDTO> getCountryById(@PathVariable Integer countryId) {
        log.debug("[getCountryById] Starting with Id: {}", countryId);
        return ResponseEntity.status(HttpStatus.OK).body(service.findCountry(countryId));
    }

    @GetMapping
    public ResponseEntity<List<CountryResponseDTO>> getAllCountries() {
        log.debug("[getAllCountries] Starting: ");
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCountries());
    }

    @PostMapping
    public ResponseEntity<CountryResponseDTO> postCreateCountry(@RequestBody @Valid CountrySaveDTO countrySaveDTO) {
        log.debug("[postCreateCountry] Starting with: {}", countrySaveDTO);
        var savedCountry = service.saveCountry(countrySaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @DeleteMapping("/{countryId}")
    public ResponseEntity<Void> deleteCountryById(@PathVariable Integer countryId) {
        log.debug("[deleteCountryById] Starting with Id: {}", countryId);
        service.deleteCountry(countryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping
    ResponseEntity<CountryResponseDTO> patchUpdateCountry(@RequestBody @Valid CountryRequestDTO countryRequestDTO) {
        log.debug("[patchUpdateCountry] Starting with: {}", countryRequestDTO);
        var updatedCountry = service.updateCountry(countryRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCountry);
    }
}
