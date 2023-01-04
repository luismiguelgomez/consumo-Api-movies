package com.talataa.prueba.ServiciosApiMovie.consumes;

import com.google.gson.Gson;
import com.talataa.prueba.ServiciosApiMovie.consumes.interfaz.MovieConsumeInterfaz;
import com.talataa.prueba.ServiciosApiMovie.dto.*;
import com.talataa.prueba.ServiciosApiMovie.dto.in.SessionDto;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MovieConsume implements MovieConsumeInterfaz {

    public static final String URL_PRINCIPAL = "https://api.themoviedb.org/3/movie/";
    public static final String URL_PRINCIPAL_SECUNDARIA = "https://api.themoviedb.org/3/";
    public static final String CLAVE_API = "06e7c71fa4bdf70a5850607d1e5cebdc";
    public static final String AUTORIZATION_BEARER = "Bearer 06e7c71fa4bdf70a5850607d1e5cebdc";

    public Movie getAll(int pagina) {
        Movie movies = new Movie();
        try {
           OkHttpClient client = new OkHttpClient().newBuilder()
                   .build();
           MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
           RequestBody body = RequestBody.create(mediaType, "");
           Request request = new Request.Builder()
                   .url(URL_PRINCIPAL+"popular?api_key="+CLAVE_API+"&language=en-US&page="+pagina)
                   .addHeader("Authorization", AUTORIZATION_BEARER)
                   .addHeader("Content-Type", "application/json;charset=utf-8")
                   .build();
           //Response response = client.newCall(request).execute();
           ResponseBody responseBody = client.newCall(request).execute().body();
           Gson gson = new Gson();
           movies = gson.fromJson(responseBody.string(), Movie.class);
       } catch (Exception e) {
            Result result = new Result();
            result.setTitle("ERROR EN CONSUMO");
            ArrayList <Result> resultArrayList = new ArrayList<>();
            resultArrayList.add(result);
            movies.setResults(resultArrayList);
       }
        return movies;
    }

    public Movie getUpcoming(int pagina, String language) {
        Movie movies = new Movie();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(URL_PRINCIPAL+"upcoming?api_key="+CLAVE_API+"&language="+language+"&page="+pagina)
                    .addHeader("Authorization", AUTORIZATION_BEARER)
                    .addHeader("Content-Type", "application/json;charset=utf-8")
                    .build();
            ResponseBody responseBody = client.newCall(request).execute().body();
            Gson gson = new Gson();
            movies = gson.fromJson(responseBody.string(), Movie.class);
        } catch (Exception e) {
            Result result = new Result();
            result.setTitle("ERROR EN CONSUMO");
            ArrayList <Result> resultArrayList = new ArrayList<>();
            resultArrayList.add(result);
            movies.setResults(resultArrayList);
        }
        return movies;
    }

    public MovieSpecific getMovieId(int movieId) {
        MovieSpecific movies = new MovieSpecific();
        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
            RequestBody body = RequestBody.create(mediaType, "");
            Request request = new Request.Builder()
                    .url(URL_PRINCIPAL+movieId+"?api_key="+CLAVE_API+"&language=en-US")
                    .addHeader("Authorization", AUTORIZATION_BEARER)
                    .addHeader("Content-Type", "application/json;charset=utf-8")
                    .build();
            ResponseBody responseBody = client.newCall(request).execute().body();
            Gson gson = new Gson();
            movies = gson.fromJson(responseBody.string(), MovieSpecific.class);
        } catch (Exception e) {
            movies.setTitle("ERROR EN CONSUMO");
        }
        return movies;
    }

    public String getToken() throws IOException {
        Response response = null;
        OkHttpClient client = new OkHttpClient().newBuilder()
               .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
               .url(URL_PRINCIPAL_SECUNDARIA+"authentication/token/new?api_key="+CLAVE_API)
               .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Gson gson = new Gson();
        TokenResponse tokenResponse= gson.fromJson(responseBody.string(), TokenResponse.class);
        return  tokenResponse.getRequest_token();
    }

    public SessionResponse createSession (SessionDto sessionDto, String token ) throws IOException {
        SessionResponse sessionResponse = new SessionResponse();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"username\": \""+sessionDto.getUsername()+
                "\",\r\n  \"password\": \""+sessionDto.getPassword()+
                "\",\r\n  \"request_token\": \""+token+"\"\r\n}");
        Request request = new Request.Builder()
                .url(URL_PRINCIPAL_SECUNDARIA+"authentication/token/validate_with_login?api_key="+CLAVE_API)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Gson gson = new Gson();
        sessionResponse = gson.fromJson(responseBody.string(), SessionResponse.class);
        return sessionResponse;
    }

    public ListResponse closeSession(String apiKey, String session) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(URL_PRINCIPAL_SECUNDARIA+"list/+44?api_key="+apiKey+"&session_id="+session)
                                .method("DELETE", body)
                                .build();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Gson gson = new Gson();
        ListResponse listResponse = gson.fromJson(responseBody.string(), ListResponse.class);
        return listResponse;
    }
}
