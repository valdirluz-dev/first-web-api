package com.my.web_api.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseError> handleNotFound(
            ResourceNotFoundException ex, //handleNotFound recebe ex para pegar a mensagem
            HttpServletRequest request) { //handleNotFound recebe request para saber qual URL foi chamada
        ResponseError error = new ResponseError( //JSON personalizado
                HttpStatus.NOT_FOUND.value(), //404
                "resource not found", // título do erro
                ex.getMessage(),//mensagem do erro
                request.getRequestURI() //URL da request
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error); //Status = 404, body = JSON error
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseError> handleBusiness(
            BusinessException ex,
            HttpServletRequest request) {
        ResponseError error = new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "Bad request error",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handle(
            Exception ex,
            HttpServletRequest request) {

        ex.printStackTrace(); // essencial pra debug

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseError(
                        500,
                        "internal server error",
                        ex.getMessage(),
                        request.getRequestURI()
                ));
    }


}

