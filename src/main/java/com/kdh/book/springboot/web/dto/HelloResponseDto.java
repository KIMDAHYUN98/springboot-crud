package com.kdh.book.springboot.web.dto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
 * 1. @Getter
 * 	 선언된 모든 필드의 get 메서드를 생성해준다
 * 2. @RequiredArgsConstructor
 * 	 선언된 모든 final 필드가 포함된 생성자
 * 	 final이 없는 필드는 생성자에 포함 X
 * */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {

	private final String name;
	private final int amount;

	// @RequestParam
	// 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
	@GetMapping
	public HelloResponseDto helloDto(@RequestParam("name") String name,
		@RequestParam("amount") int amount) {
		return new HelloResponseDto(name, amount);
	}
}
