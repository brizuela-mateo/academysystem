package com.profebrian.academysystem.student;

import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record StudentDto(Integer studentId,
                         @NotNull String firstName,
                         @NotNull String lastName,
                         @NotNull Date dateOfBirth,
                         @NotNull Integer document,
                         Integer tutorId) {
}
