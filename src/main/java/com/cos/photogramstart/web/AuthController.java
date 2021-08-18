package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller //Ioc 등록되었다. 파일을 리턴하는 컨트롤러이다
public class AuthController {

	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	private final AuthService authService; 

	
	@GetMapping("/auth/signin")
	public String sigininForm() {
		
		return "/auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String siginupForm() {
		
		return "/auth/signup";
	}
	
	@PostMapping("/auth/signup")
	public String siginup(@Valid SignupDto signupdto, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			Map<String, String> errorMap = new HashMap<>();
			
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			throw new CustomValidationException("유효성 검사 실패", errorMap);
		}else {
			//log.info(signupdto.toString()); //4개의 데이터를 받아오는지 확인
			User user = signupdto.toEntity();
			//log.info(user.toString());// 투엔티티에서 넘어오는지 확인
			User userEntity = authService.SignupUser(user);
			 System.out.println(userEntity);	//확인
			return "/auth/signin";
			
		} 
	}

	
	
}
