package com.profebrian.academysystem.auxiliary.country;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countries")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "name")
    private String countryName;

    @Column(name = "code")
    private String countryCode;


}
