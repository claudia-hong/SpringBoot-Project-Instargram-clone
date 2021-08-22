package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cos.photogramstart.config.oauth.OAuth2DetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity //해당 파일로 시큐리티를 활성화
@Configuration  //Ioc      
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final OAuth2DetailsService oAuth2DetailsService;
	
	@Bean//빈등록
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		//super.configure(http); //이걸로 계속 가로채지고 있음 삭제 >> 기존 시큐리티가 가지고 있는 기능이 비활성화
		
		http.csrf().disable();
		http.authorizeRequests()
		   .antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**","/api/**").authenticated()
		   .anyRequest().permitAll()
		   .and()
		   .formLogin()
		   .loginPage("/auth/signin") //GET
		   .loginProcessingUrl("/auth/signin") //POST
		   .defaultSuccessUrl("/")
		   .and()
		   .oauth2Login()
		   .userInfoEndpoint()
		   .userService(oAuth2DetailsService);
		
	}

	
}
