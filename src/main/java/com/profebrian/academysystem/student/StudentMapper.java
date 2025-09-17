package com.profebrian.academysystem.student;

import com.profebrian.academysystem.student.dto.StudentRequestDTO;
import com.profebrian.academysystem.student.dto.StudentResponseDTO;
import com.profebrian.academysystem.student.dto.StudentSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "city.cityId", target = "cityId")
    @Mapping(source = "tutor.tutorId", target = "tutorId")
    @Mapping(source = "documentType.documentTypeId", target = "documentTypeId")
    StudentResponseDTO toResponseDTO(Student student);

    List<StudentResponseDTO> toResponseDTO(List<Student> students);

    Student toSaveEntity(StudentSaveDTO studentSaveDTO);

    Student toUpdateEntity(StudentRequestDTO cityRequestDTO);
}
