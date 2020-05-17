package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class ParetoComparatorTest {

	@Test
	public void ParetoCompare() {
		Car[] carArray = { 
				new Car("Toyota", "RAV4", 1000, 2013, 10000), 
				new Car("Toyota", "RAV4", 2000, 2014, 20000),
				new Car("Toyota", "RAV4", 3000, 2015, 30000), 
				new Car("Toyota", "RAV4", 4000, 2016, 40000), 
				new Car("Toyota", "RAV4", 5000, 2017, 50000),
				new Car("Toyota", "RAV4", 6000, 2018, 60000), 
				new Car("Toyota", "RAV4", 7000, 2019, 70000) 
		};
		
		ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(carArray));
		
		for (Car car : cars) {
			car.setDominationCount(cars);
		}
		
		Collections.sort(cars, (Car car1, Car car2) -> {
			return car2.getDominationCount() - car1.getDominationCount();
		});
		
		assertEquals(10000, cars.get(0).getPrice());
		assertEquals(20000, cars.get(1).getPrice());
		assertEquals(30000, cars.get(2).getPrice());
		assertEquals(40000, cars.get(3).getPrice());
		assertEquals(50000, cars.get(4).getPrice());
		assertEquals(60000, cars.get(5).getPrice());
		assertEquals(70000, cars.get(6).getPrice());
	}
}
