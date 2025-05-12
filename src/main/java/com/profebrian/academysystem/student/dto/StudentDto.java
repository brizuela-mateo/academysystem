package com.profebrian.academysystem.student.dto;

import com.profebrian.academysystem.tutor.TutorDao;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.util.Date;


@Builder
public record StudentDto(@NotNull Integer student_id,
                         @NotNull String firstName,
                         @NotNull String lastName,
                         @NotNull Date dateOfBirth,
                         @NotNull Integer document,
                         TutorDao tutor) {

}
