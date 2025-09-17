package com.profebrian.academysystem.tutor;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tutors")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_id")
    private Integer tutorId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "cellphone")
    private String cellphone;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "main_tutor_id")
    private Tutor mainTutor;

}
