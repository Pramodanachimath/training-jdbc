package com.testcases.demo.check;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.training.User;

class UserTest {
	User user=null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	
	void setUp() throws Exception {
		 user=new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Tag("greet")
	@Test @DisplayName("Testing greet")
	void testGreet() {
		 
	    assertEquals("Have a great day Tom",user.greet("Tom"));

	}
	
	@Test @DisplayName("Testing fruits")
	void testFruits() {
		 
	    assertEquals(Arrays.asList("Apple","Orange","Mango"), user.showFruits());

	}
	
	@Test @DisplayName("Testing size of arrayList")
	void testSizeOfArratList() {
		 
	    assertEquals(3, user.showFruits().size());

	}
	
	

}
