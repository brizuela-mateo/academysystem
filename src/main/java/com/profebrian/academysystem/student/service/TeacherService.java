package com.profebrian.academysystem.student.service;

import com.profebrian.academysystem.student.dto.TeacherDto;
import com.profebrian.academysystem.student.dto.mapper.TeacherMapper;
import com.profebrian.academysystem.student.model.Teacher;
import com.profebrian.academysystem.student.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository,
                          TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.teacherDtoToTeacher(teacherDto);
        teacherRepository.save(teacher);
        return teacherDto;
    }

    public List<TeacherDto> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teacherMapper.teacherToTeacherDtoList(teachers);
    }

    public TeacherDto findTeacherById(Integer id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        return teacherMapper.teacherToTeacherDto(teacher);
    }

    public void deleteTeacherById(Integer id) {
        teacherRepository.deleteById(id);
    }

}
