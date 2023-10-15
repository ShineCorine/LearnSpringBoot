package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello(){

        return "<html><body><h1>Hello Spring Boot</h1></body></html>";
    }
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println(msg);
        System.out.println("age = " + age);
        System.out.println("isMan = " + isMan);
        // TODO 대문자로 변환해서 RETURN
        return msg.toUpperCase();

    }

    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam (name = "issued-month") String issuedMonth,
            @RequestParam String issued_day
    ){
        System.out.println("category = " + category);
        System.out.println("issuedYear = " + issuedYear);
        System.out.println("issuedMonth = " + issuedMonth);
        System.out.println("issued_day = " + issued_day);
    }

    @GetMapping(path = "/book2")
    public void queryparamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    //TODO : parameter 2가지 받는다. int 형태로 받아서 두 수의 덧셈, 곱셈을 리턴
    @GetMapping(path = "/assignment1")
    public int querySum(
            @RequestParam int num1,
            @RequestParam int num2
    ){
        return num1+num2;
    }

    @GetMapping(path = "/assignment2")
    public void queryIsBook(
            @RequestParam boolean isBook
    ){
        System.out.println("Book: "+ isBook);
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
    })
    public void delete(
            @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }

}
