package com.profebrian.academysystem.auxiliary.document;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "document_types")
public class DocumentType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_type_id")
    private Integer documentTypeId;

    @Column(name = "name")
    private String documentTypeName;

    @Column(name = "abbreviation")
    private String abbreviation;

}
