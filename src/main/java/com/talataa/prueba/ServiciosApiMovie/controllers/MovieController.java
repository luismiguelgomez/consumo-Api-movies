package com.talataa.prueba.ServiciosApiMovie.controllers;

import com.talataa.prueba.ServiciosApiMovie.dto.Movie;
import com.talataa.prueba.ServiciosApiMovie.services.MovieService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getAll(){
        try {
            return  movieService.getAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
