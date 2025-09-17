package com.profebrian.academysystem.tutor;

import com.profebrian.academysystem.tutor.dto.TutorRequestDTO;
import com.profebrian.academysystem.tutor.dto.TutorResponseDTO;
import com.profebrian.academysystem.tutor.dto.TutorSaveDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import java.util.List;


@Service
public class TutorService {

    private static final Logger log = LoggerFactory.getLogger(TutorService.class);

    private final TutorRepository repository;
    private final TutorMapper mapper;

    public TutorService(TutorRepository repository, TutorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public TutorResponseDTO saveTutor(TutorSaveDTO tutorSaveDTO) {
        log.debug("[saveTutor] Starting with: {}", tutorSaveDTO);
        var tutor = mapper.toSaveEntity(tutorSaveDTO);
        var mainTutorId = tutorSaveDTO.mainTutorId();
        if (mainTutorId != 0){
            tutor.setMainTutor(findTutorEntity(mainTutorId));
        }
        var savedTutor = repository.save(tutor);
        return mapper.toResponseDTO(savedTutor);
    }

    public List<TutorResponseDTO> findAllTutors() {
        log.debug("[findAllTutors] Starting: ");
        return mapper.toResponseDTO(repository.findAll());
    }

    public TutorResponseDTO findTutor(Integer id) {
        log.debug("[findTutor] Starting with id: {}", id);
        var tutor = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tutor not found with id: " + id));
        return mapper.toResponseDTO(tutor);
    }

    public void deleteTutor(Integer id) {
        log.debug("[deleteTutor] Starting with id: {}", id);
        repository.deleteById(id);
    }

    public TutorResponseDTO updateTutor(TutorRequestDTO tutorRequestDTO) {
        log.debug("[updateTutor] Starting with: {}", tutorRequestDTO);
        var tutorId = tutorRequestDTO.tutorId();
        if (repository.existsById(tutorId)){
            var tutor = mapper.toUpdateEntity(tutorRequestDTO);
            var mainTutorId = tutorRequestDTO.mainTutorId();
            if (mainTutorId != 0){
                tutor.setMainTutor(findTutorEntity(mainTutorId));
            }
            var savedTutor = repository.save(tutor);
            return mapper.toResponseDTO(savedTutor);
        } else {
            throw new ResourceNotFoundException("Tutor not found with id: " + tutorId);
        }
    }

    private Tutor findTutorEntity(Integer id) {
        log.debug("[findTutorEntity] Starting with id: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tutor not found with id: " + id));
    }
}
