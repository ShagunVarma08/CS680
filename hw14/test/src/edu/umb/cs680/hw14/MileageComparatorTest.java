package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class MileageComparatorTest {

	@Test
	public void MileageCompare() {
		Car[] carArray = { 
				new Car("Toyota", "RAV4", 1000, 2018, 30000), 
				new Car("Toyota", "RAV4", 2000, 2016, 10000),
				new Car("Toyota", "RAV4", 3000, 2018, 30000), 
				new Car("Toyota", "RAV4", 4000, 2016, 10000),
				new Car("Toyota", "RAV4", 5000, 2018, 30000), 
				new Car("Toyota", "RAV4", 6000, 2016, 10000),
				new Car("Toyota", "RAV4", 7000, 2019, 100000) 
		};
		
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		Collections.sort(cars, (Car car1, Car car2) -> {
			return car1.getMileage() - car2.getMileage();
		});
		
		assertEquals(1000, cars.get(0).getMileage());
		assertEquals(2000, cars.get(1).getMileage());
		assertEquals(3000, cars.get(2).getMileage());
		assertEquals(4000, cars.get(3).getMileage());
		assertEquals(5000, cars.get(4).getMileage());
		assertEquals(6000, cars.get(5).getMileage());
		assertEquals(7000, cars.get(6).getMileage());
	}

}

