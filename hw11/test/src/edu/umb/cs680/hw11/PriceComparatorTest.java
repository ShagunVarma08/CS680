package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class PriceComparatorTest {

	@Test
	public void compareTest() {
		Car[] carArray = { 
				new Car("Toyota", "RAV4", 5000, 2016, 250000), 
				new Car("Toyota", "RAV4", 4000, 2018, 310000),
				new Car("Toyota", "RAV4", 5000, 2016, 450000), 
				new Car("Toyota", "RAV4", 4000, 2018, 630000),
				new Car("Toyota", "RAV4", 2000, 2019, 900000) 
		};
		
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, new PriceComparator());
		
		assertEquals(250000, cars.get(0).getPrice());
		assertEquals(310000, cars.get(1).getPrice());
		assertEquals(450000, cars.get(2).getPrice());
		assertEquals(630000, cars.get(3).getPrice());
		assertEquals(900000, cars.get(4).getPrice());
	}

}
