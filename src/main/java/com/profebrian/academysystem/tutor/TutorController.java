package com.profebrian.academysystem.tutor;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @GetMapping
    public ResponseEntity<List<TutorDto>> getAllTutors() {
        return ResponseEntity.ok(tutorService.findAllTutors());
    }

    @PostMapping
    public ResponseEntity<TutorDto> createTutor(@RequestBody @Valid TutorDto tutorDto) {
        TutorDto savedTutor = tutorService.saveTutor(tutorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTutor);
    }

}
