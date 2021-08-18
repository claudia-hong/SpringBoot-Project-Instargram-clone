package com.cos.photogramstart.web.dto.user;

import javax.validation.constraints.NotBlank;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class UserUpdateDto {
	
	@NotBlank
	private String name; //필수
	@NotBlank
	private String password; //필수 
	private String website;
	private String bio;
	private String phone;
	private String gender;

	//필수가 아닌 정보들도 포함해 엔티티로 다 받는게 위험할 수 있다.
public User toEntity() {
		return User.builder()
				.name(name)
				.password(password)
				.website(website)
				.bio(bio)
				.phone(phone)
				.gender(gender)
				.build();	
	}
	
	

}
