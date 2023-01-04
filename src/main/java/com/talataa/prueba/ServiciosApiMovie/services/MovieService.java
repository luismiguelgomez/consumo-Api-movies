package com.talataa.prueba.ServiciosApiMovie.services;

import com.talataa.prueba.ServiciosApiMovie.consumes.MovieConsume;
import com.talataa.prueba.ServiciosApiMovie.consumes.interfaz.MovieConsumeInterfaz;
import com.talataa.prueba.ServiciosApiMovie.dto.ListResponse;
import com.talataa.prueba.ServiciosApiMovie.dto.Movie;
import com.talataa.prueba.ServiciosApiMovie.dto.MovieSpecific;
import com.talataa.prueba.ServiciosApiMovie.dto.SessionResponse;
import com.talataa.prueba.ServiciosApiMovie.dto.in.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieService {
    @Autowired
    private MovieConsumeInterfaz movieConsume;

    public Movie getAll(int pagina) {
        return movieConsume.getAll(pagina);
    }

    public Movie getUpcoming(int pagina, String language) {
        return movieConsume.getUpcoming(pagina,language);
    }

    public MovieSpecific getMovieId(int movieId) {
        return movieConsume.getMovieId(movieId);
    }

    public SessionResponse createSession(SessionDto sessionDto) throws IOException {
        String token = movieConsume.getToken();
        return movieConsume.createSession(sessionDto, token);
    }

    public ListResponse deleteSession(String apiKey, String session) throws IOException {
        return movieConsume.closeSession(apiKey, session);
    }
}
