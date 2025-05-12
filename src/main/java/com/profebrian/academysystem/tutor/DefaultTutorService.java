package com.profebrian.academysystem.tutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultTutorService implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public TutorDao saveTutor(TutorDao tutor) {
        return null;
    }

    @Override
    public Iterable<TutorDao> getAllTutors(Integer id) {
        return null;
    }

    @Override
    public TutorDao getTutorById(Integer id) {
        return null;
    }

    @Override
    public void deleteTutorById(Integer id) {

    }
}
