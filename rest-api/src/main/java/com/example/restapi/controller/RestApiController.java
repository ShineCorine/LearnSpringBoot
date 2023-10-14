package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello(){

        return "<html><body><h1>Hello Spring Boot</h1></body></html>";
    }
    @GetMapping(path = "/echo/{message}")
    public String echo(@PathVariable(name = "message") String msg){
        System.out.println(msg);
        // TODO 대문자로 변환해서 RETURN
        return msg.toUpperCase();

    }
}
