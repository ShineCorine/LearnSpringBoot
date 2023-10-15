package com.example.exception.controller;


import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    // 데이터베이스가 없으니 변수로 선언
    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(10)
                    .name("유관순")
                    .build()
            ,
            UserResponse.builder()
                    .id("3")
                    .age(10)
                    .name("이순신")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ){
        // test를 위해 아무 에러나 임의로 발생
        if(true) {
            throw new RuntimeException("Message");
        }

        var user = userList.stream()
                .filter(it -> it.getId().equals(userId)
                )
                .findFirst()
                .get();

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))  //int로 내려오는 http status를 문자열로 바꿈
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();

        return response;
    }
}
