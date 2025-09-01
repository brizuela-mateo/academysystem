package com.profebrian.academysystem.auxiliary.country;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Hidden
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
