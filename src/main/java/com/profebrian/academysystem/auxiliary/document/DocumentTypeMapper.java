package com.profebrian.academysystem.auxiliary.document;

import com.profebrian.academysystem.auxiliary.document.dto.DocumentTypeRequestDTO;
import com.profebrian.academysystem.auxiliary.document.dto.DocumentTypeResponseDTO;
import com.profebrian.academysystem.auxiliary.document.dto.DocumentTypeSaveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {
    DocumentTypeMapper INSTANCE = Mappers.getMapper(DocumentTypeMapper.class);

    DocumentTypeResponseDTO toResponseDTO(DocumentType documentType);

    List<DocumentTypeResponseDTO> toDTOList(List<DocumentType> countries);

    DocumentType toSaveEntity(DocumentTypeSaveDTO documentTypeSaveDTO);

    DocumentType toUpdateEntity(DocumentTypeRequestDTO documentTypeRequestDTO);
}
