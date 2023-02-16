package com.kdh.book.springboot.config.auth.dto;

import java.io.Serializable;

import com.kdh.book.springboot.domain.user.Users;

import lombok.Getter;

/*
 * 인증된 사용자 정보만 필요함
 * */
@Getter
public class SessionUser implements Serializable {
	private String name;
	private String email;
	private String picture;

	public SessionUser(Users user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
}
