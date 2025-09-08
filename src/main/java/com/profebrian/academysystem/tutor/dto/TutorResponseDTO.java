package com.profebrian.academysystem.tutor;

public record TutorDto(Integer tutorId,
                       String fullName,
                       Integer cellphone,
                       String email,
                       String ruc,
                       String rucOwner,
                       Integer mainTutorId) {
}
