package com.talataa.prueba.ServiciosApiMovie.consumes;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieConsume {
    public String getAll() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/76341?api_key=06e7c71fa4bdf70a5850607d1e5cebdc")
                .addHeader("Authorization", "Bearer 06e7c71fa4bdf70a5850607d1e5cebdc")
                .addHeader("Content-Type", "application/json;charset=utf-8")
                .build();
        //Response response = client.newCall(request).execute();
        ResponseBody responseBody = client.newCall(request).execute().body();
        Gson gson = new Gson();
        SimpleEntity entity = gson.fromJson(responseBody.string(), SimpleEntity.class);
        System.out.println(response);
        return response.body().string();
    }
}
