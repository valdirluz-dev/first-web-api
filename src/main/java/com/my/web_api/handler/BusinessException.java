package com.my.web_api.handler;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Object...params){
        super();
    }
}
