package com.profebrian.academysystem.tutor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    TutorDto tutorToDto(Tutor tutor);

    Tutor dtoToTutor(TutorDto tutorDto);

    List<TutorDto> tutorsToDtoList(List<Tutor> tutors);

    List<Tutor> dtosToTutorList(List<TutorDto> tutorDtos);

}
