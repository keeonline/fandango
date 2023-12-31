package com.keeonline.fandango.mip;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.time.LocalTime;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.keeonline.fandango.api.model.MessageBytesDto;
import com.keeonline.fandango.api.model.MessageDto;
import com.keeonline.fandango.api.service.McbnService;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;


public class MipConnection extends Thread {

    private static boolean isConnected = false;

    public static boolean isConnected() {
        return isConnected;
    }

    public static boolean notConnected() {
        return !isConnected;
    }

    public void run() {
        Socket socket;
        DataInputStream in;
        OutputStream out;

        int [] lengthBytes = new int[2];

        System.out.println("****" + System.getenv("MCBN_HOST"));

        try {
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println(this.getName() + ": MipConnection thread is running");
            try {
                socket = new Socket(System.getenv("MCBN_HOST"),11000);
                isConnected = true;
                System.out.println("MCBN connetced on port 11000");
                in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                out = socket.getOutputStream();


                while (isConnected) {
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

                    String responseHexString = onRequest(sb.toString());

                    byte[] responseBytes = new byte[responseHexString.length() / 2];
                    byte[] responseLength = ByteBuffer.allocate(4).putInt(responseBytes.length).array();

                    for (int i = 0; i < responseBytes.length; i++) {
                        int index = i * 2;
                        int val = Integer.parseInt(responseHexString.substring(index, index + 2), 16);
                        responseBytes[i] = (byte)val;
                    }

                    out.write(responseLength,2,2);
                    out.write(responseBytes);
                }
                
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

            MessageData requestBody = mcbnService.parse(requestHexString);

            BigDecimal convRate = requestBody.getConversionRateCardholderBilling();

            requestBody.setAdditionalDataPrivateUse(null);
            requestBody.setCardAcceptorNameLocation(null);
            requestBody.setConversionRateCardholderBilling(null);
            requestBody.setDateExpiration(null);
            requestBody.setPointOfServiceData(null);


            RestTemplate restTemplate = new RestTemplate();
            // HttpEntity<MessageData> requestEntity = new HttpEntity<>(requestBody);
            // ResponseEntity<MessageData> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, MessageData.class); 

            Gson gson = new Gson();
            String body = gson.toJson(requestBody);

            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("Content-Type","application/json");


            HttpEntity<String> requestEntity = new HttpEntity<>(body,requestHeaders);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class); 

            // System.out.println(responseEntity.getBody());
            MessageData messageData = gson.fromJson(responseEntity.getBody(),MessageData.class);

            if (messageData.getMessageTypeIdentifier().equals("110")) {
                messageData.setMessageTypeIdentifier("0110");
            }
            if (!messageData.getResponseCode().equals("00")) {
                messageData.setAuthorizationIdentificationResponse(null);
            }
            if (convRate != null) {
                messageData.setConversionRateCardholderBilling(convRate);
            }
            messageData.setTimeLocalTransaction(null);
            messageData.setDateLocalTransaction(null);
            messageData.setMerchantType(null);
            messageData.setPosEntryModeCode(null);

            // TransformedMessage mappedResponse = mcbnService.map(responseEntity.getBody());
            TransformedMessage mappedResponse = mcbnService.map(messageData);

            responseHexString = mappedResponse.getEncoded();

        } catch (FieldTransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return responseHexString;
    }
    
}
