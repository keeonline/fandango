package com.keeonline.fandango.api.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.keeonline.fandango.api.model.MessageBytesDto;
import com.keeonline.fandango.api.model.MessageDto;
import com.keeonline.fandango.api.service.McbnService;
import com.keeonline.fandango.iso8583.field.transformer.exception.FieldTransformerException;
import com.keeonline.fandango.iso8583.message.model.MessageData;
import com.keeonline.fandango.iso8583.message.transformer.TransformedMessage;

/*
 * "C:\Program Files\Java\jdk1.8.0_212\bin\java" -jar target\library.jar
 * 
 * curl http://localhost:8080/fandango/mcbn/ebcdic
 *
 * http://localhost:8080/library/swagger-ui.html#
 */

@RestController
@RequestMapping("/fandango/mcbn/ebcdic")
public class McbnEbcdicController {

    String baseUrl;

    public McbnEbcdicController() {
        baseUrl = System.getenv("PAYMENTS_BASE_URL");
        System.out.println("**********************baseurl=" + baseUrl);
    }
    
    @PostMapping(path = "/requests")
    public ResponseEntity<MessageBytesDto> onRequest(@RequestBody MessageBytesDto requestBytesDto) {

        McbnService mcbnService = new McbnService();
        MessageBytesDto responseBytesDto = null;

		try {
            String url = String.format("%s/payments/request", baseUrl);
            System.out.println("**********************requesturl=" + url);

            MessageData requestData = mcbnService.parse(requestBytesDto.getPayload());

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<MessageDto> requestDto = new HttpEntity<>(new MessageDto(requestData));
            ResponseEntity<MessageDto> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestDto, MessageDto.class); 

            TransformedMessage mappedResponse = mcbnService.map(responseEntity.getBody().getData());

            responseBytesDto = new MessageBytesDto(mappedResponse.getEncoded());

        } catch (FieldTransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(responseBytesDto);
    }

}
