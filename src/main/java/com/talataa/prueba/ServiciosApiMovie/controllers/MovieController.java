package com.talataa.prueba.ServiciosApiMovie.controllers;

import com.talataa.prueba.ServiciosApiMovie.dto.ListResponse;
import com.talataa.prueba.ServiciosApiMovie.dto.Movie;
import com.talataa.prueba.ServiciosApiMovie.dto.MovieSpecific;
import com.talataa.prueba.ServiciosApiMovie.dto.SessionResponse;
import com.talataa.prueba.ServiciosApiMovie.dto.in.SessionDto;
import com.talataa.prueba.ServiciosApiMovie.services.MovieService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     *
     * @param pagina pagina en la iremos
     * @return peliculas de la pagina
     */
    @RequestMapping(value = "/pagination", method = RequestMethod.GET)
    Movie getAll(@RequestParam int pagina){
        return  movieService.getAll(pagina);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    Movie getUpcoming(@RequestParam(defaultValue = "1") int pagina,
                      @RequestParam(defaultValue = "en-US") String language)
    {
      return  movieService.getUpcoming(pagina,language);
    }

    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    MovieSpecific getMovieId(@PathVariable int movieId)
    {
        return  movieService.getMovieId(movieId);
    }

    @RequestMapping(value = "/crearSession", method = RequestMethod.POST)
    SessionResponse createSession(@RequestBody SessionDto sessionDto) throws IOException {
        return  movieService.createSession(sessionDto);
    }

    @RequestMapping(value = "/crearSession", method = RequestMethod.DELETE)
    ListResponse deleteSession(@RequestParam(defaultValue = "abcdefg") String apiKey,
                               @RequestParam(defaultValue = "abcdefg") String session) throws IOException {
        return movieService.deleteSession(apiKey, session);
    }

}
