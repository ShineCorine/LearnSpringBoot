package com.example.exception.exeption;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class RestApiExceptionHandler {


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler", e);

        return ResponseEntity.status(200).build();
    }
}
