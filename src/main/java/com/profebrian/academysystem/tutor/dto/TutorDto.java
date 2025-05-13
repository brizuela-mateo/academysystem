package com.profebrian.academysystem.tutor.dto;

import jakarta.validation.constraints.NotNull;

public record TutorDto(Integer tutorId,
                       String fullName,
                       Integer cellphoneNumber,
                       String email,
                       Integer ruc,
                       String rucOwner,
                       Integer mainTutorId) {
}
