package com.profebrian.academysystem.tutor.service;

import com.profebrian.academysystem.tutor.dto.TutorDto;
import com.profebrian.academysystem.tutor.model.Tutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TutorService {
    public TutorDto saveTutor(TutorDto tutorDto);

    public List<TutorDto> findAllTutors();

    public TutorDto findTutorById(Integer id);

    public void deleteTutorById(Integer id);
}
