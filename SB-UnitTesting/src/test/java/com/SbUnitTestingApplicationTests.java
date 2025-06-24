package com;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbUnitTestingApplicationTests {

	public static CalculatorTesting c = null;

	@BeforeAll
	public static void init() {
		c = new CalculatorTesting();

	}

	@AfterAll
	public static void destroy() {
		c = null;
	}

	@Test
	@ParameterizedTest
	@ValueSource(ints = {2,3,4,5})
	public void TestAdd(int a) {
//		CalculatorTesting c = new CalculatorTesting();
		int result = c.Add(a, 5);
		assertEquals(10, result);

	}

	@Test
	public void TestMulti() {
//		CalculatorTesting c = new CalculatorTesting();
		int result = c.Multi(5, 5);
		assertEquals(25, result);

	}

}
