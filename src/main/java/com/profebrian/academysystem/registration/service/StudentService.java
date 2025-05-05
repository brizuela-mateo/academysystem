package com.profebrian.academysystem.registration.service;

import com.profebrian.academysystem.registration.model.Student;

public interface StudentService {
    public Student saveStudent(Student student);

    public Iterable<Student> getAllStudents();

    public Student getStudentById(Integer id);

    public void deleteStudentById(Integer id);
}
