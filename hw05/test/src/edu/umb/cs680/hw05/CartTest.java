package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CartTest {
	
	private String[] carToStringArray(Car car) {
		String[] carSpecifications = { 
				car.getMake(), 
				car.getModel(), 
				String.valueOf(car.getYear()) 
		};
		return carSpecifications;
	}

	@Test
	public void verifyCarEqualityWithMakeModelYear() {
		Car car1 = new Car("Toyota", "RAV4", 80, 2018, 90000);
		Car car2 = new Car("Toyota", "RAV4", 70, 2018, 100000);
		String[] expected = { "Toyota", "RAV4", "2018" };
		assertArrayEquals(expected, carToStringArray(car1));
		assertArrayEquals(expected, carToStringArray(car2));
	}

}
