package com.amritbabu.busticketcounter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@Data
@ToString
public class SuccessResponse {
    @NonNull
    private boolean success;
    @Nullable
    private String message;

    private SuccessResponse() {
        this.success=true;
    }

    private SuccessResponse(@Nullable String message) {
        this.success = true;
        this.message = message;
    }

    public static SuccessResponse getInstance(){
        return new SuccessResponse();
    }

    public static SuccessResponse getInstance(String message){
        return new SuccessResponse(message);
    }
}
