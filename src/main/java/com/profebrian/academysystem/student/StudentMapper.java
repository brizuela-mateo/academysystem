package com.profebrian.academysystem.student;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toStudentDto(Student student);

    Student toStudent(StudentDto studentDto);

    List<StudentDto> toStudentDtoList(List<Student> students);
}
