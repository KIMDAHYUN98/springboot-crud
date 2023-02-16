package com.kdh.book.springboot.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.kdh.book.springboot.domain.user.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().disable() // h2-console 화면을 사용하기위해 해당 옵션들을 disable
			.and()
			.authorizeRequests()
			.antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
			.antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 권한 관리 대상 옵션
			.anyRequest().authenticated() // 설정된 값들 이외 나머지 URL를 나타냄
			.and()
			.logout().logoutSuccessUrl("/")
			.and()
			.oauth2Login()
			.userInfoEndpoint()// OAuth2 로그인 성공 후 사용자 정보를 가져올 때 담당
			.userService(customOAuth2UserService);

		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
	}

}
