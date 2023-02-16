package com.kdh.book.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kdh.book.springboot.web.HelloController;

@SpringBootTest(classes = HelloController.class)
class KdhApplicationTests {

	@Test
	void contextLoads() {
	}

}
