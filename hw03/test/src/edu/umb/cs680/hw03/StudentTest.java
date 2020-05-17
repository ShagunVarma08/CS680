package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	public void StatusOfInStateStudentIsINSTATE() {
		Student intl = Student.createinStateStudent("John", "Boston");
		assertEquals(StudentStatus.INSTATE, intl.getStatus());
	}

	@Test
	public void StatusOfOutStateStudentIsOUTSTATE() {
		Student intl = Student.createOutStateStudent("Emma", "Florida", 3);
		assertEquals(StudentStatus.OUTSTATE, intl.getStatus());
	}

	@Test
	public void StatusOfIntlStudentIsINTL() {
		Student intl = Student.createIntlStudent("Nigen", "Boston", 555, "Turkey");
		assertEquals(StudentStatus.INTL, intl.getStatus());
	}

	@Test
	public void tuitionForIntlStudentIs20000() {
		Student intl = Student.createIntlStudent("Mike", "Boston", 465, "England");
		assertEquals(20000, intl.getTuition());
	}

	@Test
	public void tuitionForOutStateStudentIs15000() {
		Student intl = Student.createOutStateStudent("Jenna", "Boston", 5);
		assertEquals(15000, intl.getTuition());
	}

	@Test
	public void tuitionForInStateStudentIs10000() {
		Student intl = Student.createinStateStudent("Jeff", "Boston");
		assertEquals(10000, intl.getTuition());
	}

	@Test
	public void InStateStudentTuitionIsLessThanOutStateTuitionOf15000() {
		Student intl = Student.createinStateStudent("Betty", "Boston");
		float expected = 10000;
		assertEquals(expected, intl.getTuition());
	}

	@Test
	public void InStateStudentTUITIONisNot15000() {
		Student intl = Student.createinStateStudent("Ruby", "Boston");
		assertNotEquals(15000, intl.getTuition());
	}

	@Test
	public void OutStateStudentTuitionIsLessThanIntlTuitionOf20000() {
		Student intl = Student.createOutStateStudent("Alice", "Boston", 15);
		float expected = 15000;
		assertEquals(expected, intl.getTuition());
	}

	@Test
	public void OutStateStudentTUITIONisNot10000() {
		Student intl = Student.createOutStateStudent("Sam", "Boston", 9);
		assertNotEquals(10000, intl.getTuition());
	}

	@Test
	public void IntlStudentTuitionIsGreaterThanInStateTuitionOf10000() {
		Student intl = Student.createIntlStudent("Jake", "Boston", 358, "Asia");
		float expected = 20000;
		assertEquals(expected, intl.getTuition());
	}

	@Test
	public void IntlStudentTUITIONisNot10000() {
		Student intl = Student.createIntlStudent("Marc", "Boston", 120, "Europe");
		assertNotEquals(10000, intl.getTuition());
	}

}
