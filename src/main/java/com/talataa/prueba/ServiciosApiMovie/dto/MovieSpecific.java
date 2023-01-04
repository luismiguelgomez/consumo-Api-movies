package com.talataa.prueba.ServiciosApiMovie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class MovieSpecific {
    private boolean adult;
    private Object backdrop_path;
    private Object belongs_to_collection;
    private int budget;
    private ArrayList<Genre> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private ArrayList<ProductionCompany> production_companies;
    private ArrayList<ProductionCountry> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private ArrayList<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
