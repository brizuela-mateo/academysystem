package com.profebrian.academysystem.student.model;

import com.profebrian.academysystem.tutor.TutorDao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private Integer document;

    @ManyToOne
    @JoinColumn(name="tutor_id", referencedColumnName = "tutor_id")
    private TutorDao tutor;
}
