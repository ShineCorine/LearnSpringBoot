package com.example.restapi.controller;


import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {

	@GetMapping("")
	@ResponseBody
	public UserRequest user(){

		var user = new UserRequest();
		user.setUserName("홍길동");
		user.setEmail("hong@gmail.com");
		user.setIsKorean(true);
		user.setPhoneNumber("010-1111-1111");

		log.info("user: {}", user);
		var response = ResponseEntity
				.status(HttpStatus.CREATED)
				.header("x-custom", "hi")
				.body(user);

		return user;

	}
}
