package com.polytech.alertcovidservicelocation.controllers;

import com.polytech.alertcovidservicelocation.models.Location;
import com.polytech.alertcovidservicelocation.models.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations/")
public class LocationsController {
    @Autowired
    private LocationRepository locationRepository;


    @GetMapping
    public List<Location> list() {
        return locationRepository.findAll();
    }

}
