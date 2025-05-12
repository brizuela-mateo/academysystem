package com.profebrian.academysystem.tutor;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tutors")
public class TutorDao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tutor_id;

    private String fullname;

    private Integer cellphone_number;

    private String email;

    private Integer ruc;

    private String ruc_owner;

    @ManyToOne
    @JoinColumn(name = "main_tutor_id", referencedColumnName = "tutor_id")
    private TutorDao main_tutor;

}
