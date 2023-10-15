package com.example.validation.controller;


import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public Api<UserRegisterRequest> register(

        @Valid
        @RequestBody
        Api<UserRegisterRequest> userRegisterRequest
    ){
        log.info("init : {}", userRegisterRequest);

        return userRegisterRequest;
    }
}


// Resolved [org.springframework.web.bind.MethodArgumentNotValidException:
// Validation failed for argument [0] in public com.example.validation.model.UserRegisterRequest
// com.example.validation.controller.UserApiController.register(com.example.validation.model.UserRegisterRequest):
// [Field error in object 'userRegisterRequest' on field 'registerAt': rejected value [2023-01-29T13:05:10]; codes [FutureOrPresent.userRegisterRequest.registerAt,FutureOrPresent.registerAt,FutureOrPresent.java.time.LocalDateTime,FutureOrPresent]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [userRegisterRequest.registerAt,registerAt]; arguments []; default message [registerAt]]; default message [현재 또는 미래의 날짜여야 합니다]] ]