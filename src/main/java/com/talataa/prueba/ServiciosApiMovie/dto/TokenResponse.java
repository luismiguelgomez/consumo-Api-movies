package com.talataa.prueba.ServiciosApiMovie.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {
    private boolean success;
    private String expires_at;
    private String request_token;
}
