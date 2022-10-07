package com.vfislk.training;

import com.vfislk.exceptions.InValidNumberException;
import com.vfislk.exceptions.NegValueException;

public class Student {
	public int calTotal(int m1, int m2, int m3) throws RuntimeException {
		if (m1 < 0 || m2 < 0 || m3 < 0) {
			throw new NegValueException("marks should be greater than zero");
		}
		if (m1 > 100 || m2 > 100 || m3 > 100) {
			throw new InValidNumberException("Enter marks less than 100 ");
		}
		return m1 + m2 + m3;

	}

	public String getGrades(int[] marks) {

		int sum = 0;
		if (marks == null) {
			return "marks are not initialised";
		}
		for (int i : marks) {
			if (i < 0)
				throw new NegValueException();

			sum += i;
		}

		int avg = (sum / marks.length);
		if (avg > 100) {
			throw new InValidNumberException();
		}

		if (avg >= 90) {
			return "A";
		}
		if (avg >= 80 && avg < 90) {
			return "B";
		}
		if (avg >= 60 && avg < 80) {
			return "C";
		}
		if (avg >= 50 && avg < 60) {
			return "D";
		} else {
			return "Fail";
		}
	}

}
