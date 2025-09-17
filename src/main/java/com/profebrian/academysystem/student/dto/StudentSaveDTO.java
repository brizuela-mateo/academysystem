package com.profebrian.academysystem.student.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record StudentSaveDTO(@NotNull @Size(max = 50)
                                 String firstName,
                             @NotNull @Size(max = 50)
                                 String lastName,
                             @NotNull
                                 Date dateOfBirth,
                             @Size(max = 15)
                                 String ruc,
                             @Size(max = 100)
                                 String ruc_owner,
                             @NotNull
                                 Integer documentTypeId,
                             @NotNull
                                 Integer cityId,
                             Integer tutorId) {
}
