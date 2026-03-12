package com.my.web_api.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.access.AccessDeniedException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class) public ResponseEntity<ResponseError> handleAccessDenied(
            AccessDeniedException ex,
            HttpServletRequest request) {
        ResponseError error = new ResponseError(
                HttpStatus.FORBIDDEN.value(),
                "forbidden",
                "Você não tem permissão para acessar este recurso",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

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
        ResponseError error = new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "internal server error",
                "Unexpected error occurred",
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }


}

