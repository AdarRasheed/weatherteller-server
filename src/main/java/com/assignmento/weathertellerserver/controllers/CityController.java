package com.assignmento.weathertellerserver.controllers;

import com.assignmento.weathertellerserver.models.City;
import com.assignmento.weathertellerserver.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing {@link com.assignmento.weathertellerserver.models.City}.
 */
@RestController
public class CityController {

    @Autowired
    CityRepository cityRepository;

    /**
     * {@code GET  /cities : Retrieve all cities known to the system.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the list of all city known to the system
     */
    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {

        return new ResponseEntity<>(cityRepository.findAll(), HttpStatus.OK);
    }
}
