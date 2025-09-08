package com.profebrian.academysystem.teacher;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
