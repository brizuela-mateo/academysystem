package com.profebrian.academysystem.auxiliary.document;

import com.profebrian.academysystem.auxiliary.document.dto.DocumentTypeRequestDTO;
import com.profebrian.academysystem.auxiliary.document.dto.DocumentTypeResponseDTO;
import com.profebrian.academysystem.auxiliary.document.dto.DocumentTypeSaveDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DocumentTypeService {

    private static final Logger log = LoggerFactory.getLogger(DocumentTypeService.class);

    private final DocumentTypeRepository repository;
    private final DocumentTypeMapper mapper;

    public DocumentTypeService(DocumentTypeRepository documentTypeRepository, DocumentTypeMapper mapper) {
        this.repository = documentTypeRepository;
        this.mapper = mapper;
    }

    @Transactional
    public DocumentTypeResponseDTO saveDocumentType(DocumentTypeSaveDTO documentTypeSaveDTO) {
        log.debug("[saveDocumentType] Starting with: {}", documentTypeSaveDTO);
        DocumentType documentType = mapper.toDocumentTypeEntity(documentTypeSaveDTO);
        var savedCountry = repository.save(documentType);
        return mapper.toDocumentTypeDTO(savedCountry);
    }

    public List<DocumentTypeResponseDTO> findAllDocumentTypes() {
        log.debug("[findAllDocumentTypes] Starting: ");
        var countries = repository.findAll();
        return mapper.toDocumentTypeDTOList(countries);
    }

    public DocumentTypeResponseDTO findDocumentyType(Integer id) {
        log.debug("[findDocumentyType] Starting with id: {}: ", id);
        var foundDocumentType = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        return mapper.toDocumentTypeDTO(foundDocumentType);
    }

    @Transactional
    public void deleteDocumentType(Integer id) {
        log.debug("[deleteDocumentType] Starting with id: {}: ", id);
        repository.deleteById(id);
    }

    @Transactional
    public DocumentTypeResponseDTO updateDocumentType(DocumentTypeRequestDTO documentTypeRequestDTO) {
        log.debug("[updateDocumentType] Starting with: {}: ", documentTypeRequestDTO);
        var documentType = mapper.toDocumentTypeEntity(documentTypeRequestDTO);
        var documentTypeId = documentType.getDocumentTypeId();
        if (repository.existsById(documentTypeId)) {
            var updatedDocumentType = repository.save(documentType);
            return mapper.toDocumentTypeDTO(updatedDocumentType);
        } else {
            throw new ResourceNotFoundException("Country not found with id: " + documentTypeId);
        }
    }

}
