package com.profebrian.academysystem.student;

import com.profebrian.academysystem.registration.exception.StudentNotFoundException;
import com.profebrian.academysystem.tutor.TutorMapper;
import com.profebrian.academysystem.tutor.TutorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudenService")
public class DefaultStudentService implements StudentService {

    private final StudentMapper studentMapper;

    private final StudentRepository studentRepository;

    private final TutorService tutorService;

    private final TutorMapper tutorMapper;

    public DefaultStudentService(StudentMapper studentMapper, StudentRepository studentRepository, TutorService tutorService, TutorMapper tutorMapper) {
        this.studentMapper = studentMapper;
        this.studentRepository = studentRepository;
        this.tutorService = tutorService;
        this.tutorMapper = tutorMapper;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = studentMapper.toStudent(studentDto);
        var tutorId = studentDto.tutorId();
        if (tutorId != null) student.setTutor(tutorMapper.dtoToTutor(tutorService.findTutorById(tutorId)));
        return studentMapper.toStudentDto(studentRepository.save(student));
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return studentMapper.toStudentDtoList(studentRepository.findAll());
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
