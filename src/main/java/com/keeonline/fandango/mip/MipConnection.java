package com.keeonline.fandango.mip;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.time.LocalTime;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.keeonline.fandango.api.model.MessageDto;
import com.keeonline.fandango.api.service.McbnService;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;


public class MipConnection extends Thread {

    private static boolean isConnected = false;

"{\"messageTypeIdentifier\":\"0100\",\"primaryAccountNumber\":5039990000100006,\"processingCode\":{\"transactionType\":0,\"accountTypeFrom\":0,\"accountTypeTo\":0},\"amountTransaction\":{\"amount\":10,\"currency\":\"GBP\"},\"amountCardholderBilling\":{\"amount\":10,\"currency\":\"GBP\"},\"transmissionDateAndTime\":{\"date\":{\"year\":2023,\"month\":10,\"day\":30},\"time\":{\"hour\":15,\"minute\":15,\"second\":43,\"nano\":0}},\"conversionRateCardholderBilling\":1.000000,\"systemTraceAuditNumber\":9,\"timeLocalTransaction\":{\"hour\":15,\"minute\":11,\"second\":22,\"nano\":0},\"dateLocalTransaction\":{\"year\":2023,\"month\":10,\"day\":31},\"dateExpiration\":{\"year\":2023,\"month\":10,\"day\":29},\"dateSettlement\":{\"year\":2023,\"month\":10,\"day\":31},\"dateConversion\":{\"year\":2023,\"month\":10,\"day\":31},\"merchantType\":5311,\"posEntryModeCode\":{\"panEntryMode\":1,\"pinEntryMode\":0},\"acquiringInstitutionIdentificationCode\":130000,\"retrievalReferenceNumber\":\"000000000001\",\"cardAcceptorTerminalIdentification\":\"T0000000\",\"cardAcceptorIdentificationCode\":\"A000000\",\"cardAcceptorNameLocation\":{\"cardAcceptorOrAtmLocation\":\"A STORE 0000\",\"cityName\":\"LONDON\",\"countryCode\":\"GBP\"},\"additionalDataPrivateUse\":\"R9203721\",\"pointOfServiceData\":\"0001000000700826E1 6AN\",\"privateUseFields\":\"MCC000001\"}";

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
        int [] messageBytes = new int[2000];

        System.out.println("****" + System.getenv("MCBN_HOST"));

        while (true) {
            System.out.println(this.getName() + ": MipConnection thread is running");
            try {
                socket = new Socket(System.getenv("MCBN_HOST"),11000);
                isConnected = true;
                System.out.println("MCBN connetced on port 11000");
                in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                out = socket.getOutputStream();

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

                for (byte b : responseLength) {
                    System.out.format("==================>>>> 0x%x ", b);
                 }

                for (int i = 0; i < responseBytes.length; i++) {
                    int index = i * 2;
                    int val = Integer.parseInt(responseHexString.substring(index, index + 2), 16);
                    responseBytes[i] = (byte)val;
                }

                out.write(responseLength,2,2);
                out.write(responseBytes);
                
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
