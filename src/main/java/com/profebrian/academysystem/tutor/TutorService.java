package com.profebrian.academysystem.tutor;

import org.springframework.stereotype.Service;

@Service
public interface TutorService {
    public TutorDao saveTutor(TutorDao tutor);

    public Iterable<TutorDao> getAllTutors(Integer id);

    public TutorDao getTutorById(Integer id);

    public void deleteTutorById(Integer id);
}
