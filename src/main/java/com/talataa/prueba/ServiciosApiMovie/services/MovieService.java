package com.talataa.prueba.ServiciosApiMovie.services;

import com.talataa.prueba.ServiciosApiMovie.consumes.MovieConsume;
import com.talataa.prueba.ServiciosApiMovie.dto.Movie;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiremock.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieConsume movieConsume;

    public String getAll() throws IOException {
        return movieConsume.getAll();
    }
}
