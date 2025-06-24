package com.profebrian.academysystem.tutor;

import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
    public TutorDto saveTutor(TutorDto tutorDto)
    {
        Tutor tutor = tutorMapper.tutorDtotoTutor(tutorDto);
        var mainTutorId = tutor.getMainTutorId();
        if(mainTutorId != null)
        {
            if (tutorRepository.existsById(mainTutorId)) {
                throw new ResourceNotFoundException("Main Tutor not found with ID: " + mainTutorId);
            }
        }
        Tutor savedTutor = tutorRepository.save(tutor);
        return tutorMapper.tutorToTutorDto(savedTutor);
    }

    @Override
    public List<TutorDto> findAllTutors() {
        return  tutorMapper.tutorsToTutorDtoList(tutorRepository.findAll());
    }

    @Override
    public TutorDto findTutorById(Integer id) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tutor not found with id: " + id));
        return tutorMapper.tutorToTutorDto(tutor);
    }

    @Override
    public void deleteTutorById(Integer id) {
        tutorRepository.deleteById(id);
    }
//
//    @Override
//    public TutorDto updateTutor(TutorDto tutorDto) {
//        tutorRepository.save()
//    }
}
