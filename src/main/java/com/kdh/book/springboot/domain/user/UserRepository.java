package com.kdh.book.springboot.domain.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
	// 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자 인지 판단하기 위한 메서드
	Optional<Users> findByEmail(String email);
}