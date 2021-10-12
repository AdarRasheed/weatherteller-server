package com.assignmento.weathertellerserver.controllers;

import com.assignmento.weathertellerserver.models.WeatherStamp;
import com.assignmento.weathertellerserver.repos.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for managing {@link com.assignmento.weathertellerserver.models.WeatherStamp}.
 */
@RestController
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

    /**
     * {@code GET  /weather-stamps/:cityOpenweatherId} : Retrieve all weather-stamps for a particular country.
     *
     * @param cityOpenweatherId the openweather.org platform assigned id for a city
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of weatherStamp, or with status {@code 204 (No Content)} if no weatherStamp for requested city yet has been gathered.
     */
    @GetMapping("/weather-stamps/{cityOpenweatherId}")
    public ResponseEntity<List<WeatherStamp>> getWeatherstampsByCountry(@PathVariable Long cityOpenweatherId) {

        List<WeatherStamp> weatherStamps = new ArrayList<>();

        weatherRepository.findTop5ByCityOpenweatherIdEqualsOrderByReportedOnDesc(cityOpenweatherId).forEach(weatherStamps::add);

        if (weatherStamps.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(weatherStamps, HttpStatus.OK);
    }

}
