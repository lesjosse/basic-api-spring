package com.redes.app.isp.dto;

public class ApiResponse<T> {

    private String mensaje;
    private T data;

    public ApiResponse(String mensaje, T data) {
        this.mensaje = mensaje;
        this.data = data;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getData() {
        return data;
    }
}