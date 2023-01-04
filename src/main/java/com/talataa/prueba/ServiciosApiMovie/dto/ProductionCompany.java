package com.talataa.prueba.ServiciosApiMovie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductionCompany {
    private int id;
    private Object logo_path;
    private String name;
    private String origin_country;
}
