package com.profebrian.academysystem.student.dto;

import com.profebrian.academysystem.student.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto toStudentDto(Student student);
    Student toStudent(StudentDto studentDto);
}
