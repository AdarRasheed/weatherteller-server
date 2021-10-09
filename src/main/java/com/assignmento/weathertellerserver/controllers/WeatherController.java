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

@RestController
public class WeatherController {

    @Autowired
    WeatherRepository weatherRepository;

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
