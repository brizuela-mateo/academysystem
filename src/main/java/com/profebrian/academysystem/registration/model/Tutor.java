package com.profebrian.academysystem.registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tutors")
public class Tutor {
    @Id
    private Integer tutor_id;

}
