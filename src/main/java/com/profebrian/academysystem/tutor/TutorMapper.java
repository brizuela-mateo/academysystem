package com.profebrian.academysystem.tutor;

import com.profebrian.academysystem.tutor.dto.TutorRequestDTO;
import com.profebrian.academysystem.tutor.dto.TutorResponseDTO;
import com.profebrian.academysystem.tutor.dto.TutorSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    TutorResponseDTO toResponseDTO(Tutor tutor);

    Tutor dtoToTutor(TutorResponseDTO tutorResponseDTO);

    List<TutorResponseDTO> toResponseDTO(List<Tutor> tutors);

    Tutor toUpdateEntity(TutorRequestDTO tutorRequestDTO);

    Tutor toSaveEntity(TutorSaveDTO tutorSaveDTO);
}
