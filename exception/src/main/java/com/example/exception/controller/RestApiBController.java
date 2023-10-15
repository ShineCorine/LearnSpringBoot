package com.example.exception.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("number format exception");
    }


    //ExceptionHanlder 어노테이션을 달면 해당 컨트롤러 내에서 예욀르 캐치한다.
    // 만약 없으면 이 예제에서는 RestApiExceptionHandler 에서 정의된 핸들러로 가게 된다.
    // 그렇지만 컨트럴로 코드가 길어지면 추천하지 않고 exception handler를 만들어 따로 지정해줄 수 있다.
    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity numberFormatException(
            NumberFormatException e
    ){
        log.error("NumberFormatException", e);
        return ResponseEntity.ok().build();
    }
}
