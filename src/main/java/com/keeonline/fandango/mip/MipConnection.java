package com.keeonline.fandango.mip;

import java.net.*;
import java.io.*;
import java.time.LocalTime;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.keeonline.fandango.api.model.MessageBytesDto;
import com.keeonline.fandango.api.model.MessageDto;
import com.keeonline.fandango.api.service.McbnService;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;


public class MipConnection extends Thread {

    private static boolean isConnected = false;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public static boolean isConnected() {
        return isConnected;
    }

    public static boolean notConnected() {
        return !isConnected;
    }

    public void run() {
        Socket socket;
        DataInputStream in;

        int [] lengthBytes = new int[2];
        int [] messageBytes = new int[2000];

        System.out.println("****" + System.getenv("MCBN_HOST"));

        while (true) {
            System.out.println(this.getName() + ": MipConnection thread is running");
            try {
                socket = new Socket(System.getenv("MCBN_HOST"),11000);
                isConnected = true;
                System.out.println("MCBN connetced on port 11000");
                in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                lengthBytes[0] = in.readUnsignedByte();
                lengthBytes[1] = in.readUnsignedByte();

                int readlen = lengthBytes[0] << 8;
                readlen += lengthBytes[1];

                System.out.println("Bytes to read=" + readlen);

                StringBuilder sb = new StringBuilder();
                for (int i = 0 ; i < readlen ; i++){
                    sb.append(String.format("%02X",in.readUnsignedByte()));
                }

                System.out.println(sb.toString()); 

                onRequest(sb.toString());
                
            } catch (Exception e) {
                System.out.println(String.format("unable to connect to MCBN. time=%s", LocalTime.now().toString()));
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public String onRequest(String requestHexString) {

        String baseUrl = System.getenv("PAYMENTS_BASE_URL");
        System.out.println("**********************baseurl=" + baseUrl);

        McbnService mcbnService = new McbnService();
        String responseHexString = null;

		try {
            String url = String.format("%s/payments/requests", baseUrl);
            System.out.println("**********************requesturl=" + url);

            

            MessageData requestData = mcbnService.parse(requestHexString);

            System.out.println(requestData);

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MessageDto> requestDto = new HttpEntity<>(new MessageDto(requestData));
            ResponseEntity<MessageDto> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestDto, MessageDto.class); 

            TransformedMessage mappedResponse = mcbnService.map(responseEntity.getBody().getData());

            responseHexString = mappedResponse.getEncoded();

            System.out.println("\n\n>>>>>>>>>>>\n" +responseHexString);

        } catch (FieldTransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return responseHexString;
    }
    
}
