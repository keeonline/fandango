package com.keeonline.fandango.api.service;

import com.google.gson.Gson;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.message.adapter.MessageDataAdapter;
import com.keeonline.fandango.iso8583.message.adapter.MessageDataAdapterVersion1987;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;
import com.keeonline.fandango.iso8583.scheme.transformer.McbnTransformer;

public class McbnService {

    private static final String FIELD_NAME_PREFIX = "DE";

    public McbnService() {}
    
	public TransformedMessage map(MessageData messageData) throws FieldTransformerException{

        Gson gson = new Gson();
        System.out.println(gson.toJson(messageData));
        System.out.println("\n\n");

        McbnTransformer transformer = new McbnTransformer();

        MessageDataAdapter adapter = new MessageDataAdapterVersion1987(FIELD_NAME_PREFIX);

        TransformedMessage transformedMessage = transformer.map(messageData, adapter);
        System.out.println(transformedMessage.report());

        return transformedMessage;
    }

	public MessageData parse(String payload) throws FieldTransformerException{
        McbnTransformer transformer = new McbnTransformer();

        TransformedMessage transformedMessage = transformer.parse(payload);

        System.out.println(transformedMessage.report());

        MessageDataAdapter adapter = new MessageDataAdapterVersion1987(FIELD_NAME_PREFIX);
        MessageData messageData = adapter.messageDataFromTransformedMessage(transformedMessage);

        Gson gson = new Gson();
        System.out.println(gson.toJson(messageData));

        return messageData;
    }

}
