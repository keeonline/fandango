package com.keeonline.fandango.api.model;

public class MessageBytesDto {
    private String payload;

    public MessageBytesDto(String encoded) {
    }

    public void setPayload(String payload) {
        this.payload = payload;
    } 

    public String getPayload() {
        return payload;
    }

}
