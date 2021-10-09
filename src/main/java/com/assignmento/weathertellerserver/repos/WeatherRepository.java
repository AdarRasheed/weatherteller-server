package com.assignmento.weathertellerserver.repos;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherStamp, Long> {

    List<WeatherStamp> findByCityContainingOrderByRecordedOnDesc(String city);
}
