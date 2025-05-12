package com.profebrian.academysystem.student.controller;

import com.profebrian.academysystem.student.dto.StudentDto;
import com.profebrian.academysystem.student.model.Student;
import com.profebrian.academysystem.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
        StudentDto studentdto = studentService.findStudentById(id);
        return ResponseEntity.ok(studentdto);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@Valid @RequestBody StudentDto studentDto) {
        return ResponseEntity.ok("Test");
    }
}
