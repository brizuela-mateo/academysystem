package com.profebrian.academysystem.student.service;

import com.profebrian.academysystem.student.dto.StudentDto;
import com.profebrian.academysystem.student.model.Student;

public interface StudentService {
    public Student saveStudent(StudentDto studentDto);

    public Iterable<Student> findAllStudents();

    public StudentDto findStudentById(Integer id);

    public void deleteStudentById(Integer id);
}
