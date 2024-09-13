package com.sp.Assigment02.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Api_Response<T>{
    private String statusCode;
    private String message;
    private T data;

}
