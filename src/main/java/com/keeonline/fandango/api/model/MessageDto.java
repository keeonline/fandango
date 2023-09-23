package com.keeonline.fandango.api.model;

import com.keeonline.fandango.iso8583.message.model.MessageData;

public class MessageDto {
    
	private MessageData data;

    public MessageDto(MessageData data) {
        setData(data);
    }

    public MessageData getData() {
        return data;
    }

    public void setData(MessageData data) {
        this.data = data;
    }
}
