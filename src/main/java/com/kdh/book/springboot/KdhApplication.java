package com.kdh.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // JPA Auditing 활성화
public class KdhApplication {
	// 메인 클래스 : 프로젝트 최상단 위에 위치

	public static void main(String[] args) {
		SpringApplication.run(KdhApplication.class, args);
	}

}
