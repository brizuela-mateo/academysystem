package com.profebrian.academysystem.student.repository;

import com.profebrian.academysystem.student.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {


}
