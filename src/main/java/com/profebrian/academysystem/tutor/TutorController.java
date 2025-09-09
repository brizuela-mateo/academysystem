package com.profebrian.academysystem.tutor;

import com.profebrian.academysystem.tutor.dto.TutorRequestDTO;
import com.profebrian.academysystem.tutor.dto.TutorResponseDTO;
import com.profebrian.academysystem.tutor.dto.TutorSaveDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private static final Logger log = LoggerFactory.getLogger(TutorService.class);

    private final TutorService service;

    public TutorController(TutorService service) {
        this.service = service;
    }

    @GetMapping("/{tutorId}")
    public ResponseEntity<TutorResponseDTO> getTutorById(@PathVariable Integer tutorId) {
        log.debug("[getTutorById]: Starting with id: {}", tutorId);
        return ResponseEntity.status(HttpStatus.OK).body(service.findTutor(tutorId));
    }

    @GetMapping
    public ResponseEntity<List<TutorResponseDTO>> getAllTutors() {
        log.debug("[getAllTutors]: Starting:");
        return ResponseEntity.status(HttpStatus.OK).body(service.findAllTutors());
    }

    @PostMapping
    public ResponseEntity<TutorResponseDTO> postCreateTutor(@RequestBody @Valid TutorSaveDTO tutorSaveDTO) {
        log.debug("[postCreateTutor]: Starting with: {}", tutorSaveDTO);
        TutorResponseDTO savedTutor = service.saveTutor(tutorSaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTutor);
    }

    @DeleteMapping("/{tutorId}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Integer tutorId) {
        log.debug("[deleteTutor]: Starting with id: {}", tutorId);
        service.deleteTutor(tutorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping
    public ResponseEntity<TutorResponseDTO> patchUpdateTutor(@RequestBody @Valid TutorRequestDTO tutorRequestDTO) {
        log.debug("[patchUpdateTutor]: Starting with: {}", tutorRequestDTO);
        var updatedTutor = service.updateTutor(tutorRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTutor);
    }

}
