package com.profebrian.academysystem.student;

import java.util.List;

public interface StudentService {
    public StudentDto saveStudent(StudentDto studentDto);

    public List<StudentDto> findAllStudents();

    public StudentDto findStudentById(Integer id);

    public void deleteStudentById(Integer id);

}
