package com.keeonline.fandango.api.model;

public class PingResponseDto {

    private String message;

    public PingResponseDto(){
        message = "pong";
    }
    
    public String getMessage() {
        return message;
    }

}
