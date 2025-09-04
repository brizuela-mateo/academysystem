package com.profebrian.academysystem.auxiliary.city;

import com.profebrian.academysystem.auxiliary.city.dto.CityCreateDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityRequestDTO;
import com.profebrian.academysystem.auxiliary.city.dto.CityResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityResponseDTO> getCityById(@PathVariable Integer cityId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findCity(cityId));
    }

    @GetMapping
    public ResponseEntity<List<CityResponseDTO>> getAllCities() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllCities());
    }

    @PostMapping
    public ResponseEntity<CityResponseDTO> postCreateCity(@RequestBody @Valid CityCreateDTO cityCreateDTO) {
        var createdCountry = service.saveCity(cityCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCountry);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Void> deleteCity(@PathVariable Integer cityId) {
        service.deleteCity(cityId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping
    ResponseEntity<CityResponseDTO> updateCity(@RequestBody @Valid CityRequestDTO cityRequestDTO) {
        var updatedCountry = service.updateCity(cityRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedCountry);
    }
}
