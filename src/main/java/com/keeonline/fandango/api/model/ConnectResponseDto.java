package com.keeonline.fandango.api.model;

public class ConnectResponseDto {

    private String message;

    public ConnectResponseDto(){
        message = "MIP connection initiated";
    }
    
    public String getMessage() {
        return message;
    }

}
