package com.talataa.prueba.ServiciosApiMovie.consumes.interfaz;

import com.talataa.prueba.ServiciosApiMovie.dto.ListResponse;
import com.talataa.prueba.ServiciosApiMovie.dto.Movie;
import com.talataa.prueba.ServiciosApiMovie.dto.MovieSpecific;
import com.talataa.prueba.ServiciosApiMovie.dto.SessionResponse;
import com.talataa.prueba.ServiciosApiMovie.dto.in.SessionDto;

import java.io.IOException;

public interface MovieConsumeInterfaz {
    public Movie getAll(int pagina);
    public Movie getUpcoming(int pagina, String language);
    public MovieSpecific getMovieId(int movieId);
    public String getToken() throws IOException;
    public SessionResponse createSession (SessionDto sessionDto, String token ) throws IOException;
    public ListResponse closeSession(String apiKey, String session) throws IOException;
}
