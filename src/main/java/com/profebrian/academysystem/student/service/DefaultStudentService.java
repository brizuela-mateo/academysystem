package com.profebrian.academysystem.student.service;

import com.profebrian.academysystem.registration.exception.StudentNotFoundException;
import com.profebrian.academysystem.student.dto.StudentDto;
import com.profebrian.academysystem.student.dto.StudentMapper;
import com.profebrian.academysystem.student.model.Student;
import com.profebrian.academysystem.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultStudentService implements StudentService {

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    public DefaultStudentService(StudentMapper studentMapper, StudentRepository studentRepository) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(StudentDto studentDto) {
        Student student = studentMapper.toStudent(studentDto);
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentDto findStudentById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with Id: " + id, id));
        return studentMapper.toStudentDto(student);
    }

    @Override
    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }
}
