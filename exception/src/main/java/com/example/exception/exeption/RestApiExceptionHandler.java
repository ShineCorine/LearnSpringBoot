package com.example.exception.exeption;


import com.example.exception.controller.RestApiBController;
import com.example.exception.controller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@Slf4j
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
@Order(1) // 숫자가 작읈구록 먼저 실행된다.
//클래스를 지정하여 예외를 처리하는 방법
public class RestApiExceptionHandler {

    //GlobalExceptionHanlder와 동일한 예외처리 핸들러를 넣어서 우선순위가 제대로 작동하는지 확인

    @ExceptionHandler(value = { Exception.class})
    public ResponseEntity<Api> exception(
            Exception e
    ){
        log.error("", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
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
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ){
        log.error("", e);

        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build()
                ;
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
