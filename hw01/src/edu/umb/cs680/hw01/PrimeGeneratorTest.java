package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void generatePrimeNumbersFrom1To10() {
		PrimeGenerator gen = new PrimeGenerator(1, 10);
		gen.generatePrimes();
		Long[] expectedPrimes = { 2L, 3L, 5L, 7L };
		assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
	}

	@Test
	public void generate_PrimeNumbersFrom0To0_Then_RuntimeExceptionOccurs() {
		try {
			PrimeGenerator gen = new PrimeGenerator(0, 0);
			gen.generatePrimes();
			fail("Wrong input values: from=0 to=0");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values from =0 and to =0", e.getMessage());
		}
	}

	@Test
	public void primeGeneratorFrom100To1GeneratesRuntimeException() {
		try {
			PrimeGenerator gen = new PrimeGenerator(100, 1);
			gen.generatePrimes();
			fail("Wrong input values from = 100 and to = 1");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values from =100 and to =1", e.getMessage());
		}
	}
	
	@Test
	public void generate_PrimeNumbersFromNegative10To10_Then_RuntimeExceptionOccurs() {
		try {
			PrimeGenerator gen = new PrimeGenerator(-10, 10);
			gen.generatePrimes();
			fail("Wrong input values: from=-10 to=10");
		} catch (RuntimeException e) {
			assertEquals("Wrong input values from =-10 and to =10", e.getMessage());
		}
	}

	@Test
	public void generatePrimeNumbersWith2As1stParameterAnd50As2ndParameter() {
		PrimeGenerator gen = new PrimeGenerator(2, 50);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L};
		assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
	}
	
	@Test
	public void generatePrimeNumbersFrom1To100() {
		PrimeGenerator gen = new PrimeGenerator(1, 100);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
		assertArrayEquals(expectedPrimes, gen.getPrimes().toArray());
	}
}
