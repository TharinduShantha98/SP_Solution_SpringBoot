package com.sp.Assigment02.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {

    private int statusCode;
    private String message;
    private String errorMessage;
    private String details;


}
