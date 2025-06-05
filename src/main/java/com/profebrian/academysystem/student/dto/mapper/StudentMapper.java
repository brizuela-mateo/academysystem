package com.profebrian.academysystem.student.dto.mapper;

import com.profebrian.academysystem.student.dto.StudentDto;
import com.profebrian.academysystem.student.model.Student;
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
