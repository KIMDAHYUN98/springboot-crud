package com.kdh.book.springboot.config.auth.dto;

import java.util.Map;

import com.kdh.book.springboot.domain.user.Role;
import com.kdh.book.springboot.domain.user.Users;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String picture;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes,
		String nameAttributeKey, String name,
		String email, String picture) {

		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}

	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
		Map<String, Object> attributes) {

		if ("naver".equals(registrationId)) {
			return ofNaver("id", attributes);
		}

		return ofGoogle(userNameAttributeName, attributes);
	}

	/*
	 * OAuth2User 에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나 변환해야 함
	 * */
	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
			.name((String)attributes.get("name"))
			.email((String)attributes.get("email"))
			.picture((String)attributes.get("picture"))
			.attributes(attributes)
			.nameAttributeKey(userNameAttributeName)
			.build();
	}

	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		return OAuthAttributes.builder()
			.name((String)response.get("name"))
			.email((String)response.get("email"))
			.picture((String)response.get("picture"))
			.attributes(response)
			.nameAttributeKey(userNameAttributeName)
			.build();
	}

	/*
	 * 유저 엔티티를 생성
	 * OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때
	 * 클래스 생성이 끝나면 같은 패키지에 SessionUser 클래스 생성
	 * */
	public Users toEntity() {
		return Users.builder()
			.name(name)
			.email(email)
			.picture(picture)
			.role(Role.USER)
			.build();
	}
}
