package com.amritbabu.busticketcounter.dto;

import lombok.Data;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@ToString
public class ErrorResponse {
    @NonNull
    private boolean success;
    @Nullable
    private String message;

    public ErrorResponse() {
        this.success = false;
    }

    public ErrorResponse(@Nullable String message) {
        this.success=false;
        this.message = message;
    }

    public static ErrorResponse getInstance(){
        return new ErrorResponse();
    }

    public static ErrorResponse getInstance(String message){
        return new ErrorResponse(message);
    }


}
