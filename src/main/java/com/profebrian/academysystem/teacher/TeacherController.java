package com.profebrian.academysystem.teacher;

import com.profebrian.academysystem.auxiliary.country.CountryController;
import com.profebrian.academysystem.teacher.dto.TeacherRequestDTO;
import com.profebrian.academysystem.teacher.dto.TeacherResponseDTO;
import com.profebrian.academysystem.teacher.dto.TeacherSaveDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(CountryController.class);

    private final TeacherService service;

    public TeacherController(final TeacherService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacherById(@PathVariable Integer id) {
       log.debug("[getTeacherById] Starting with id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(service.findTeacher(id));
    }

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody @Valid TeacherSaveDTO teacherSaveDTO) {
        log.debug("[createTeacher] Starting with: {}", teacherSaveDTO);
        var savedTeacher = service.saveTeacher(teacherSaveDTO);
        return ResponseEntity.ok(savedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherById(@PathVariable Integer id) {
        log.debug("[deleteTeacherById] Startign with id: {}", id);
        service.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<TeacherResponseDTO> getAllTeachers() {
        log.debug("[getAllTeachers] Starting: ");
        return service.findAllTeachers();
    }

    @PatchMapping
    public ResponseEntity<TeacherResponseDTO> patchUpdateTeacher(@RequestBody @Valid TeacherRequestDTO teacherRequestDTO) {
        log.debug("[patchUpdateTeacher] Starting with: {}", teacherRequestDTO);
        var updatedTeacher = service.updateTeacher(teacherRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedTeacher);
    }

}
