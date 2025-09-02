package com.profebrian.academysystem.auxiliary.city;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Hidden
public interface CityRepository extends JpaRepository<City, Integer> {
}
