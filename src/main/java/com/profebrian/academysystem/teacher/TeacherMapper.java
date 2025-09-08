package com.profebrian.academysystem.teacher;

import com.profebrian.academysystem.teacher.dto.TeacherRequestDTO;
import com.profebrian.academysystem.teacher.dto.TeacherResponseDTO;
import com.profebrian.academysystem.teacher.dto.TeacherSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher toSaveEntity(TeacherSaveDTO teacherSaveDTO);

    TeacherResponseDTO toResponseDTO(Teacher teacher);

    List<TeacherResponseDTO> toResponseListDTO(List<Teacher> teachers);

    Teacher toUpdateEntity(TeacherRequestDTO teacherRequestDTO);
}
