package com.testcases.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.training.Calculator;

class CalculatorTest {

	@BeforeAll
	public static void init() {
		System.out.println("called before all the testcases");
	}

	Calculator calculator;

	@BeforeEach
	public void setup() {
		calculator = new Calculator();
		System.out.println("called before each testcases");
	}

	@Tag("testAdd")
	@Test
	public void testAdd() {
		System.out.println("Testing....");
		int actual = calculator.sum(10, 20);
		assertEquals(30, actual);
	}

	@Test
	public void testPoduct() {
		System.out.println("Testing....");
		int actual = calculator.product(4, 2);
		assertEquals(8, actual);
	}

	@AfterEach
	public void teardown() {
		calculator = null;
		System.out.println("called before each testcases");
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("called after all testcases");
	}

}

