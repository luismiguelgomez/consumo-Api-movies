package com.talataa.prueba.ServiciosApiMovie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListResponse {
    private boolean success;
    private int status_code;
    private String status_message;
}
