package com.profebrian.academysystem.tutor.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TutorResponseDTO(@NotNull
                               Integer tutorId,
                               @NotNull @Size(max = 100)
                               String fullName,
                               @Size(max = 20)
                               String cellphone,
                               @Size(max = 320)
                               String email,
                               Integer mainTutorId) {
}
