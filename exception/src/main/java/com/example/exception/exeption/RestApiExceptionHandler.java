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

    // 원하는 예외만 캐치하기
    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build();
    }
}
