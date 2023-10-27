package com.keeonline.fandango.api.model;

public class StateResponseDto {

    private String state;

    public StateResponseDto(String state){
        this.state = state;
    }
    
    public String getMessage() {
        return state;
    }

}
