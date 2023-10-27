package com.keeonline.fandango.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keeonline.fandango.api.model.ConnectResponseDto;
import com.keeonline.fandango.api.model.StateResponseDto;
import com.keeonline.fandango.mip.MipConnection;

/*
 * "C:\Program Files\Java\jdk1.8.0_212\bin\java" -jar target\library.jar
 * 
 * curl http://localhost:8080/fandango/mcbn/ebcdic
 *
 * http://localhost:8080/library/swagger-ui.html#
 */

@RestController
@RequestMapping("/fandango/mcbn")
public class McbnController {

    public McbnController() {
    }
    
    @GetMapping(path = "/state")
    public ResponseEntity state() {
        if (MipConnection.isConnected()) {
            return ResponseEntity.ok().body(new StateResponseDto("ready"));
        }
        else {
            return ResponseEntity.accepted().body(new StateResponseDto("lively"));
        }
    }

    @GetMapping(path = "/connect")
    public ResponseEntity connect() {

        if (MipConnection.notConnected()) {
            // start connection thread
            MipConnection t = new MipConnection();
            t.start();
        }

        return ResponseEntity.ok().body(new ConnectResponseDto());
    }

}
