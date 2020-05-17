package edu.umb.cs680.hw13.observer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw13.multicast.DJIAQuoteObservable;
import edu.umb.cs680.hw13.multicast.PiechartObserver;
import edu.umb.cs680.hw13.multicast.StockQuoteObservable;
import edu.umb.cs680.hw13.multicast.THREEDObserver;
import edu.umb.cs680.hw13.multicast.TableObserver;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class ObserverTest {
	
	PiechartObserver piechartObserver = new PiechartObserver();
	TableObserver tableObserver = new TableObserver();
	THREEDObserver threeDObserver = new THREEDObserver();
	
	StockQuoteObservable stock = new StockQuoteObservable();
	DJIAQuoteObservable djia = new DJIAQuoteObservable();

	@Test
	public void DJIATest() {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		Random random = new Random(10);
		float quote = random.nextFloat() * 10;
		
		djia.addObserver(threeDObserver);
		djia.addObserver(tableObserver);
		djia.addObserver(piechartObserver);
		
		djia.changeQuote(quote);
		
		assertEquals("3D Observer DJIAEvent		: " + quote + "Table Observer DJIAEvent		: " + quote 
				+ "PieChart Observer DJIAEvent		: " + quote, byteArrayOutputStream.toString());
	
		byteArrayOutputStream.reset();
		quote = random.nextFloat() * 10;
		djia.changeQuote(quote);
		
		assertEquals("3D Observer DJIAEvent		: " + quote + "Table Observer DJIAEvent		: " + quote 
				+ "PieChart Observer DJIAEvent		: " + quote, byteArrayOutputStream.toString());
	}

	@Test
	public void StockTest() {
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(byteArrayOutputStream));
		Random random = new Random(10);
		float quote = random.nextFloat() * 10;
		
		stock.addObserver(threeDObserver);
		stock.addObserver(tableObserver);
		stock.addObserver(piechartObserver);
		
		stock.changeQuote("apple", quote);
		
		assertEquals("3D Observer StockEvent		: " + "apple" + " " + quote + "Table Observer StockEvent		: " + "apple" 
				+ " " + quote + "PieChart Observer StockEvent		: " + "apple" + " " 
				+ quote, byteArrayOutputStream.toString());
		
		byteArrayOutputStream.reset();
		quote = random.nextFloat() * 10;
		stock.changeQuote("google", quote);
		
		assertEquals("3D Observer StockEvent		: " + "google" + " " + quote + "Table Observer StockEvent		: " + "google" 
				+ " " + quote + "PieChart Observer StockEvent		: " + "google" + " " 
				+ quote, byteArrayOutputStream.toString());
	}
}