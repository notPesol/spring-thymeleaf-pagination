package com.pesol.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pesol.spring.entity.Post;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringWebapp01ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void compare() {
		Post p1 = new Post("P1", "D1");
		Post p2 = new Post("P1", "D1");

		assertEquals(p1, p2);
	}
}
