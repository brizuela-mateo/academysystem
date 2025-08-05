package com.profebrian.academysystem.tutor;

import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import java.util.List;


@Service
public class TutorService {

    private final TutorRepository repository;

    private final TutorMapper mapper;

    public TutorService(TutorRepository tutorRepository, TutorMapper tutorMapper) {
        this.repository = tutorRepository;
        this.mapper = tutorMapper;
    }

    public TutorDto saveTutor(TutorDto tutorDto)
    {
        var tutor = mapper.dtoToTutor(tutorDto);
        var mainTutorId = tutor.getMainTutorId();
        if(mainTutorId != null)
        {
            if (repository.existsById(mainTutorId)) {
                throw new ResourceNotFoundException("Main tutor not found with ID: " + mainTutorId);
            }
        }
        var savedTutor = repository.save(tutor);
        return mapper.tutorToDto(savedTutor);
    }

    public List<TutorDto> findAllTutors() {
        return  mapper.tutorsToDtoList(repository.findAll());
    }

    public TutorDto findTutorById(Integer id) {
        Tutor tutor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tutor not found with id: " + id));
        return mapper.tutorToDto(tutor);
    }

    public void deleteTutorById(Integer id) {
        repository.deleteById(id);
    }

    public TutorDto updateTutor(TutorDto tutorDto) {
        return null;
    }
}
