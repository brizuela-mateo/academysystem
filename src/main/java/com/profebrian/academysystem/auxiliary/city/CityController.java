package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CitySaveDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityRequestDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private static final Logger log = LoggerFactory.getLogger(CityController.class);

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityResponseDTO> getCityById(@PathVariable Integer cityId) {
        log.debug("[getCityById] Starting with Id: {}", cityId);
        return ResponseEntity.status(HttpStatus.OK).body(service.findCity(cityId));
    }

    @GetMapping
    public ResponseEntity<List<CityResponseDTO>> getAllCities() {
        log.debug("[getAllCities] Starting: ");
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCities());
    }

    @PostMapping
    public ResponseEntity<CityResponseDTO> postCreateCity(@RequestBody @Valid CitySaveDTO citySaveDTO) {
        log.debug("[postCreateCity] Starting with: {}", citySaveDTO);
        var createdCountry = service.saveCity(citySaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer cityId) {
        log.debug("[deleteCity] Starting with Id: {}", cityId);
        service.deleteCity(cityId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping
    ResponseEntity<CityResponseDTO> updateCity(@RequestBody @Valid CityRequestDTO cityRequestDTO) {
        log.debug("[updateCity] Starting with: {}", cityRequestDTO);
        var updatedCountry = service.updateCity(cityRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCountry);
    }
}
