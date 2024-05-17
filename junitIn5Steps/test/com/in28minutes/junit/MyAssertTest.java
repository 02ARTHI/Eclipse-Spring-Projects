package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyAssertTest {
	
	@BeforeAll
	static void beforeall() {
		System.out.println("beforeall");
	}
	
	@BeforeEach
	void beforeeach() {
		System.out.println("before each");
	}

	@Test
	void test() {
		System.out.println("test1");
	}
	
	@Test
	void test1() {
		System.out.println("test2");
	}
	
	@Test
	void test2() {
		System.out.println("test3");
	}
	
	@AfterEach
	void aftereach() {
		System.out.println("after each");
	}
	
	@AfterAll
	static void afterall() {
		System.out.println("afterall");
	}


}
