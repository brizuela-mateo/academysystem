package com.profebrian.academysystem.teacher;

import com.profebrian.academysystem.teacher.dto.TeacherRequestDTO;
import com.profebrian.academysystem.teacher.dto.TeacherResponseDTO;
import com.profebrian.academysystem.teacher.dto.TeacherSaveDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {

    private static final Logger log = LoggerFactory.getLogger(TeacherService.class);

    private final TeacherRepository repository;
    private final TeacherMapper mapper;

    public TeacherService(TeacherRepository repository, TeacherMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public TeacherResponseDTO saveTeacher(TeacherSaveDTO teacherSaveDTO) {
        log.info("[saveTeacher] Starting with: {}", teacherSaveDTO);
        Teacher teacher = mapper.toSaveEntity(teacherSaveDTO);
        return mapper.toResponseDTO(repository.save(teacher));
    }

    public List<TeacherResponseDTO> findAllTeachers() {
        log.info("[findAllTeachers] Starting: ");
        List<Teacher> teachers = repository.findAll();
        return mapper.toResponseListDTO(teachers);
    }

    public TeacherResponseDTO findTeacher(Integer id) {
        log.info("[findTeacher] Starting with id: {}: ", id);
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));;
        return mapper.toResponseDTO(teacher);
    }

    @Transactional
    public void deleteTeacher(Integer id) {
        log.info("[deleteTeacher] Starting with id: {}: ", id);
        repository.deleteById(id);
    }

    public TeacherResponseDTO updateTeacher(TeacherRequestDTO teacherRequestDTO) {
        log.info("[updateTeacher] Starting with: {}", teacherRequestDTO);
        var teacher = mapper.toUpdateEntity(teacherRequestDTO);
        var teacherId = teacher.getTeacherId();
        if (repository.existsById(teacherId)) {
            var savedTeacher = repository.save(teacher);
            return mapper.toResponseDTO(savedTeacher);
        } else {
            throw new ResourceNotFoundException("Teacher not found with id: " + teacherId);
        }
    }
}
