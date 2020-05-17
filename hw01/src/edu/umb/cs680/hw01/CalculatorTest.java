package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void multiply3By4() {
		Calculator cut = new Calculator();
		float expected = 12;
		float actual = cut.multiply(3, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply10Times5() {
		Calculator cut = new Calculator();
		float expected = 50;
		float actual = cut.multiply(10, 5);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply0By0Returns0() {
		Calculator cut = new Calculator();;
		float expected = 0;
		float actual = cut.multiply(0, 0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void multiply26As1stParameterBy0As2ndParameter() {
		Calculator cut = new Calculator();
		float expected = 0;
		float actual = cut.multiply(26, 0);
		assertEquals(expected, actual);
	}

	@Test
	public void multiplyNegative12By2() {
		Calculator cut = new Calculator();
		float expected = -24;
		float actual = cut.multiply(-12, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply3TimesNegative3() {
		Calculator cut = new Calculator();
		float expected = -9;
		float actual = cut.multiply(3, -3);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply10Point5By10() {
		Calculator cut = new Calculator();
		float expected = 105f;
		float actual = cut.multiply(10.5f, 10f);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply10And8Point6() {
		Calculator cut = new Calculator();
		float expected = 86.3f;
		float actual = cut.multiply(10f, 8.63f);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply7Point0And6() {
		Calculator cut = new Calculator();
		float expected = 25.0f;
		float actual = cut.multiply(5.0f, 5f);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply2ThousandBy3Thousand() {
		Calculator cut = new Calculator();
		float expected = 6000000;
		float actual = cut.multiply(2000, 3000);
		assertEquals(expected, actual);
	}

	@Test
	public void multiply_Negavtive16By4_Then_MultiplyResultBy2() {
		Calculator cut = new Calculator();
		float result = cut.multiply(-16, 4);
		float expected = -128;
		float actual = cut.multiply(result, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void divide5By4() {
		Calculator cut = new Calculator();
		float expected = 1.25f;
		float actual = cut.divide(5, 4);
		assertEquals(expected, actual);
	}
	
	@Test
	public void divide3By4() {
		Calculator cut = new Calculator();
		float expected = 0.75f;
		float actual = cut.divide(3, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void divide5By0GeneratesIllegalArgumentException() {
		Calculator cut = new Calculator();
		try {
			cut.divide(5, 0);
			fail("Division by zero");
		} catch (IllegalArgumentException ex) {
			assertEquals("division by zero", ex.getMessage());
		}
	}
	
	@Test
	public void divide0By8() {
		Calculator cut = new Calculator();
		float expected = 0;
		float actual = cut.divide(0, 8);
		assertEquals(expected, actual);
	}

	@Test
	public void divisionOf0By0GeneratesIllegalArgumentException() {
		Calculator cut = new Calculator();
		try {
			cut.divide(0, 0);
			fail("Division by zero");
		} catch (IllegalArgumentException ex) {
			assertEquals("division by zero", ex.getMessage());
		}
	}

	@Test
	public void divide36ByNegative1() {
		Calculator cut = new Calculator();
		float expected = -36;
		float actual = cut.divide(36, -1);
		assertEquals(expected, actual);
	}

	@Test
	public void divide1ByNegative2() {
		Calculator cut = new Calculator();
		float expected = -0.5f;
		float actual = cut.divide(1f, -2f);
		assertEquals(expected, actual);
	}

	@Test
	public void divideNegative12As1stArgumentByNegative3As2ndArgument() {
		Calculator cut = new Calculator();
		float expected = 4;
		float actual = cut.divide(-12, -3);
		assertEquals(expected, actual);
	}

	@Test
	public void divide6Point0By6() {
		Calculator cut = new Calculator();
		float actual = cut.divide(6.0f, 6);
		float expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void divide2By4() {
		Calculator cut = new Calculator();
		float expected = 0.5f;
		float actual = cut.divide(2, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void divide7Point7By7() {
		Calculator cut = new Calculator();
		float expected = 1.1f;
		float actual = cut.divide(7.7f, 7);
		assertEquals(expected, actual);
	}

	@Test
	public void divide2Point5By0Point5Returns5() {
		Calculator cut = new Calculator();
		float expected = 5;
		float actual = cut.divide(2.5f, 0.5f);
		assertEquals(expected, actual);
	}

	@Test
	public void divide20Point0By4Results10() {
		Calculator cut = new Calculator();
		float expected = 10;
		float actual = cut.divide(20.0f, 2);
		assertEquals(expected, actual);
	}

	@Test
	public void divideNegative30ThousandBy3Thousand() {
		Calculator cut = new Calculator();
		float expected = -10;
		float actual = cut.divide(-30000, 3000);
		assertEquals(expected, actual);
	}

	@Test
	public void divide_Negavtive100By10_Then_DivideResultBy5() {
		Calculator cut = new Calculator();
		float result = cut.divide(-100, 10);
		float expected = -2;
		float actual = cut.divide(result, 5);
		assertEquals(expected, actual);
	}
}
