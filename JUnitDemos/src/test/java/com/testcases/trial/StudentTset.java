package com.testcases.trial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.vfislk.exceptions.InValidNumberException;
import com.vfislk.exceptions.NegValueException;
import com.vfislk.training.Student;

class StudentTset {

	Student student = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		student = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;

	}

	@Test
	@DisplayName("Testing calTotal")
	void testCalTotal() throws NegValueException, InValidNumberException {
		assertEquals(220, student.calTotal(90, 60, 70));
	}

	@Test
	@DisplayName("Testing negative value")
	void testNegTotal() {

		assertThrows(NegValueException.class, () -> student.calTotal(-90, 90, 80));
	}

	@Test
	@DisplayName("Testing greater than 100")
	void testGreaterTotal() {

		assertThrows(InValidNumberException.class, () -> student.calTotal(120, 200, 80));
	}

	@Tag("gradeA")
	@Test
	@DisplayName("Testing grade A")
	void testGradeA() {
		int[] marks = { 90, 89, 95 };
		String grade = student.getGrades(marks);
		assertEquals("A", grade, "Expexting grade A");
	}

	@Test
	@DisplayName("Testing grade B")
	void testGradeB() {
		int[] marks = { 60, 89, 95 };
		String grade = student.getGrades(marks);
		assertEquals("B", grade, "Expexting grade B");
	}

	@Test
	@DisplayName("Testing grade C")
	void testGradeC() {
		int[] marks = { 60, 69, 75 };
		String grade = student.getGrades(marks);
		assertEquals("C", grade, "Expexting grade C");
	}

	@Tag("gradeD")
	@Test
	@DisplayName("Testing grade D")
	void testGradeD() {
		int[] marks = { 60, 59, 55 };
		String grade = student.getGrades(marks);
		assertEquals("D", grade, "Expexting grade D");
	}

	@Test
	@DisplayName("Testing grade Fail")
	void testGradeFail() {
		int[] marks = { 55, 29, 50 };
		String grade = student.getGrades(marks);
		assertEquals("Fail", grade, "Expexting grade Fail");
	}

	@Test
	@DisplayName("Testing average greater than 100")
	void testAverageTotal() {
		int[] marks = { 120, 99, 255 };
		assertThrows(InValidNumberException.class, () -> student.getGrades(marks));
	}

	@Test
	@DisplayName("Testing negative")
	void testNegative() {
		int[] marks = { -59, -60, 255 };
		assertThrows(NegValueException.class, () -> student.getGrades(marks));
	}

	@Test
	@DisplayName("Testing Zero")
	void testZero() {
		int[] marks = null;
		assertEquals("marks are not initialised", student.getGrades(marks));
	}

	@Test
	@DisplayName("Testing less Than Zero And Greater Than Marks")
	void testGreaterThanLessThan() {
		int[] marks = { 59, 55, 255 };
		assertThrows(InValidNumberException.class, () -> student.getGrades(marks));
	}

}
