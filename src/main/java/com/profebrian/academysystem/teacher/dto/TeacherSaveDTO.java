package com.profebrian.academysystem.teacher.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TeacherSaveDTO(@NotNull @Size(max = 50)
                             String firstName,
                             @NotNull @Size(max = 50)
                             String lastName) {
}
