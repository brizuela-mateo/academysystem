package com.profebrian.academysystem.student;

import com.profebrian.academysystem.auxiliary.city.City;
import com.profebrian.academysystem.auxiliary.document.DocumentType;
import com.profebrian.academysystem.tutor.Tutor;
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
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    private String cellphone;

    private String email;

    private Character gender;

    private String ruc;

    @Column(name = "ruc_owner")
    private String rucOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_type_id", referencedColumnName = "document_type_id")
    private DocumentType documentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id", referencedColumnName = "tutor_id")
    private Tutor tutor;

}
