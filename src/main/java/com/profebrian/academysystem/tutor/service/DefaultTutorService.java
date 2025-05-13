package com.profebrian.academysystem.tutor.service;

import com.profebrian.academysystem.tutor.dto.TutorDto;
import com.profebrian.academysystem.tutor.dto.TutorMapper;
import com.profebrian.academysystem.tutor.model.Tutor;
import com.profebrian.academysystem.tutor.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTutorService implements TutorService {

    private final TutorRepository tutorRepository;

    private final TutorMapper tutorMapper;

    public DefaultTutorService(TutorRepository tutorRepository, TutorMapper tutorMapper) {
        this.tutorRepository = tutorRepository;
        this.tutorMapper = tutorMapper;
    }

    @Override
    public TutorDto saveTutor(TutorDto tutorDto) {
        Tutor tutor = tutorMapper.toTutor(tutorDto);
        Tutor savedTutor = tutorRepository.save(tutor);
        return tutorMapper.toTutorDto(savedTutor);
    }

    @Override
    public List<TutorDto> findAllTutors() {
        return  tutorMapper.toTutorDtoList(tutorRepository.findAll());
    }

    @Override
    public TutorDto findTutorById(Integer id) {
        return null;
    }

    @Override
    public void deleteTutorById(Integer id) {

    }
}
