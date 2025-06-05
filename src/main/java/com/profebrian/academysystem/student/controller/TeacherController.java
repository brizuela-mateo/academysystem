package com.profebrian.academysystem.student.controller;

import com.profebrian.academysystem.student.dto.TeacherDto;
import com.profebrian.academysystem.student.service.TeacherService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(final TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Integer id) {
        TeacherDto teacherDto = teacherService.findTeacherById(id);
        return ResponseEntity.ok(teacherDto);
    }

    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody @Valid TeacherDto teacherDto) {
        TeacherDto teacherDtoSaved = teacherService.saveTeacher(teacherDto);
        return ResponseEntity.ok(teacherDtoSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Integer id) {
        teacherService.deleteTeacherById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<TeacherDto> getAllTeachers() {
        return teacherService.findAllTeachers();
    }




}
