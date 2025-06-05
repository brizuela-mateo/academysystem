package com.profebrian.academysystem.student.dto.mapper;

import com.profebrian.academysystem.student.dto.TeacherDto;
import com.profebrian.academysystem.student.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher teacherDtoToTeacher(TeacherDto teacherDto);

    TeacherDto teacherToTeacherDto(Teacher teacher);

    List<TeacherDto> teacherToTeacherDtoList(List<Teacher> teachers);
}
