package com.profebrian.academysystem.auxiliary.document.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DocumentTypeResponseDTO(@NotNull
                                 Integer documentTypeId,
                                      @NotNull @Size(max = 50)
                                 String documentTypeName,
                                      @NotNull @Size(max = 10)
                                 String abbreviation) {
}
