package com.in28minutes.rest.webservices.restfulwebservices.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseObject {
    private int statusCode;
    private String message;
    private Object data;
}
