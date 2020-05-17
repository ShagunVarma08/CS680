package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Car {

	private String model, make;
	private int mileage, year;
	private float price;
	private int dominationCount;

	public Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public String getMake() {
		return make;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return this.dominationCount;
	}

	public void setDominationCount(ArrayList<Car> cars) {
		// Finish up setting the domination counts for all cars
		// by calling setDominationCount() on those cars, and
		// then call sort()
		for (Car car : cars) {
			if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
					&& (car.getYear() <= this.getYear())) {
				this.dominationCount++;
			}
		}
		this.dominationCount--; 	
	}

	public static void main(String[] args) {
		
		Car car = new Car("Toyota", "RAV4", 20, 2018, 90000);
		System.out.println("Model: " + car.getModel());
		System.out.println("Make: " + car.getMake());
		System.out.println("Mileage: " + car.getMileage());
		System.out.println("Year: " + car.getYear());
		System.out.println("Price: " + car.getPrice());

	}
}