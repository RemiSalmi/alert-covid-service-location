package com.polytech.alertcovidservicelocation.controllers;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.polytech.alertcovidservicelocation.models.Location;
import com.polytech.alertcovidservicelocation.models.LocationRepository;
import com.polytech.alertcovidservicelocation.models.User;
import com.polytech.alertcovidservicelocation.services.JsonBodyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import com.auth0.jwt.JWT;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/locations/")
public class LocationsController {
    @Autowired
    private LocationRepository locationRepository;


    @GetMapping()
    public List<Location> listByUser(@RequestHeader("Authorization") String authorization) {
        String token = authorization.split(" ")[1];
        DecodedJWT jwt = JWT.decode(token);
        String email = jwt.getClaim("email").asString();
        long idUser = 0;

        var client = HttpClient.newHttpClient();
        String url = "http://146.59.234.45:8081/users/" + email;
        var request = HttpRequest.newBuilder(
                URI.create(url))
                .header("Authorization", authorization)
                .build();

        HttpResponse<Supplier<User>> response = null;
        try {
            response = client.send(request, new JsonBodyHandler<>(User.class));
            return locationRepository.findByIdUser(response.body().get().id_user);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException( HttpStatus .INTERNAL_SERVER_ERROR, "can't get your id from your token" ) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new ResponseStatusException( HttpStatus .INTERNAL_SERVER_ERROR, "can't get your id from your token" ) ;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@RequestBody final Location location) {
        return locationRepository.saveAndFlush(location);
    }

}
