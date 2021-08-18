package com.cos.photogramstart.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails {
	

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user=user;
	}
	
	@Override //권한 가져오는 함수 //권한은 한개가 아닐 수 있으므로 타입이 컬렉션이다.
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collerctor = new ArrayList<>();
		collerctor.add(()-> {return user.getRole();});
		
		return collerctor;
	}

	@Override 
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override //네 계정이 만료되었니?
	public boolean isAccountNonExpired() {
		return true; //아니=트루 (false면 로그인이 안됨)
	}

	@Override //네 계정이 잠겼니?
	public boolean isAccountNonLocked() {
		return true; //아니=트루
	}

	@Override //네 비밀번호가 1년이 지났는데 안 바뀐거 아니니?
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override //네 계정이 활성화 되어 있니?
	public boolean isEnabled() {
		return true;
	}

}
