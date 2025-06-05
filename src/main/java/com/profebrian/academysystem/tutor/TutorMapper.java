package com.profebrian.academysystem.tutor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TutorMapper {
    TutorMapper INSTANCE = Mappers.getMapper(TutorMapper.class);

    @Mapping(source = "mainTutor.tutorId", target = "mainTutorId")
    TutorDto toTutorDto(Tutor tutor);

    Tutor toTutor(TutorDto tutorDto);

    List<TutorDto> toTutorDtoList(List<Tutor> tutors);

    List<Tutor> toTutorList(List<TutorDto> tutorDtos);

}
