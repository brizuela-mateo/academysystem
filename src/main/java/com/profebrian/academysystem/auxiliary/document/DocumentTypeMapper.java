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

    DocumentTypeResponseDTO toDocumentTypeDTO(DocumentType documentType);

    List<DocumentTypeResponseDTO> toDocumentTypeDTOList(List<DocumentType> countries);

    List<DocumentType> toDocumentTypeList(List<DocumentTypeResponseDTO> documentTypeResponseDTOList);

    DocumentType toDocumentTypeEntity(DocumentTypeSaveDTO documentTypeSaveDTO);

    DocumentType toDocumentTypeEntity(DocumentTypeRequestDTO documentTypeRequestDTO);
}
