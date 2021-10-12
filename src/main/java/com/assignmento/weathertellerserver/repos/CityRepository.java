package com.assignmento.weathertellerserver.repos;

import com.assignmento.weathertellerserver.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link CityRepository} entity.
 */
public interface CityRepository extends JpaRepository<City, Long> {



}
