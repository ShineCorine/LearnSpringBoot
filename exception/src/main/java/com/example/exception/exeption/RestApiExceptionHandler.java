package com.example.exception.exeption;


import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@Slf4j
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
//클래스를 지정하여 예외를 처리하는 방법
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

    @ExceptionHandler(value = {NoSuchElementException.class})
    public Api noSuchElement(
            NoSuchElementException e
    ){
        log.error("", e);

        return Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build()
                ;

        /* 예상 결과값
        {
            "result_code": "404",
            "result_message": "Not Found",
            "data": null
}
        }
         */
    }
}
