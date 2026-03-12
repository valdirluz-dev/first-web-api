package com.my.web_api.handler;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String message){
        super(message);
    }

    public ResourceNotFoundException (String message, Object...params){
        super();
    }
}
