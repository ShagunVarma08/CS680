package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class YearComparatorTest {

	@Test
	public void YearCompare() {
		Car[] carArray = { 
				new Car("Toyota", "RAV4", 2000, 2016, 110000), 
				new Car("Toyota", "RAV4", 3000, 2018, 250000),
				new Car("Toyota", "RAV4", 4000, 2019, 900000) 
		};
		
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, (Car car1, Car car2) -> {
			return car2.getYear() - car1.getYear();
		});
		
		assertEquals(2019, cars.get(0).getYear());
		assertEquals(2018, cars.get(1).getYear());
		assertEquals(2016, cars.get(2).getYear());
	}

}