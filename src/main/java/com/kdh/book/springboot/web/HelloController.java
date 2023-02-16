package com.kdh.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
	@RestController
	1. 컨트롤러를 JSON을 반환하는 컨트롤러로 생성
	2. @ResponseBody를 각 메서드 마다 선언했던 것을 한번에 사용하게 해줌
 */
@RestController
public class HelloController {

	/*
		@GetMapping
		- http method인 get 요청을 받을 수 있는 API 생성
	 */
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
