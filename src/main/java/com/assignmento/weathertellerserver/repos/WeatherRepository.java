package com.assignmento.weathertellerserver.repos;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link WeatherStamp} entity.
 */
public interface WeatherRepository extends JpaRepository<WeatherStamp, Long> {

    List<WeatherStamp> findTop5ByCityOpenweatherIdEqualsOrderByReportedOnDesc(Long cityOpenweatherId);

}
