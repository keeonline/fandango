package com.keeonline.fandango.api.model;

public class MessageBytesDto {
    private String payload;

    public MessageBytesDto() {
    }

    public MessageBytesDto(String encoded) {
        this.payload = encoded;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    } 

    public String getPayload() {
        return payload;
    }

}
