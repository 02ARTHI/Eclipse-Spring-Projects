package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();
	
	@Test
	void test() {
		System.out.println(math.calculateSum(new int[] {1,2,3,4}));
		assertEquals(10,math.calculateSum(new int[] {1,2,3,4}));
	}
	
	@Test
	void test1() {
		System.out.println(math.calculateSum(new int[] {}));
		assertEquals(0,math.calculateSum(new int[] {}));
	}

}
