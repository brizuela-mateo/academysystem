package com.profebrian.academysystem.tutor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tutors")
public class Tutor
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutor_id")
    private Integer tutorId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "cellphone_number")
    private Integer cellphoneNumber;

    private String email;

    private Integer ruc;

    @Column(name = "ruc_owner")
    private String rucOwner;

    @ManyToOne
    @JoinColumn(name = "main_tutor_id", referencedColumnName = "tutor_id")
    private Tutor mainTutor;

}
