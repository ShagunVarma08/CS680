package edu.umb.cs680.hw13.multicast;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class MulticastTest {
	
	StockQuoteObservable stock = new StockQuoteObservable();
	DJIAQuoteObservable djia = new DJIAQuoteObservable();

	PiechartObserver piechartObserver = new PiechartObserver();
	TableObserver tableObserver = new TableObserver();
	THREEDObserver threeDObserver = new THREEDObserver();
	
	@Test
	public void DJIATest() {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		Random randomNumber = new Random(10);
		float quote = randomNumber.nextFloat() * 10;
		
		djia.addObserver(threeDObserver);
		djia.addObserver(tableObserver);
		djia.addObserver(piechartObserver);
		
		djia.changeQuote(quote);
		
		assertEquals("3D Observer DJIAEvent		: " + quote + "Table Observer DJIAEvent		: " + quote 
					+ "PieChart Observer DJIAEvent		: " + quote, byteArrayOutputStream.toString());
		
		byteArrayOutputStream.reset();
		quote = randomNumber.nextFloat() * 10;
		djia.changeQuote(quote);
		
		assertEquals("3D Observer DJIAEvent		: " + quote + "Table Observer DJIAEvent		: " + quote 
				+ "PieChart Observer DJIAEvent		: " + quote, byteArrayOutputStream.toString());
	}

	@Test
	public void StockTest() {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		Random randomNumber = new Random(10);
		float quote = randomNumber.nextFloat() * 10;
		
		stock.addObserver(threeDObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(piechartObserver);
		
		stock.changeQuote("apple", quote);
		
		assertEquals("3D Observer StockEvent		: " + "apple" + " " + quote + "Table Observer StockEvent		: " + "apple" 
					+ " " + quote + "PieChart Observer StockEvent		: " + "apple" + " " 
					+ quote, byteArrayOutputStream.toString());
		
		byteArrayOutputStream.reset();
		quote = randomNumber.nextFloat() * 10;
		stock.changeQuote("google", quote);
		
		assertEquals("3D Observer StockEvent		: " + "google" + " " + quote + "Table Observer StockEvent		: " + "google" 
					+ " " + quote + "PieChart Observer StockEvent		: " + "google" + " " 
					+ quote, byteArrayOutputStream.toString());
	}
}