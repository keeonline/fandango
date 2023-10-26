package com.keeonline.fandango.api.model;

import com.keeonline.fandango.mip.MipConnection;

public class StateResponseDto {

    private String message;

    public StateResponseDto(){
        // if (MipConnection.isConnected()) {
            message = "ready";
    //     }
    //     else {
    //         message = "lively";
    //     }
    }
    
    public String getMessage() {
        return message;
    }

}
