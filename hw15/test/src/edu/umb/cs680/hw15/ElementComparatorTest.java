package edu.umb.cs680.hw15;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ElementComparatorTest {

	static private LocalDateTime date1 = LocalDateTime.now();
	static private LocalDateTime date2 = LocalDateTime.now();
	
	static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date1, "Admin", date2);
	
	static ApfsDirectory applications = new ApfsDirectory(null, "Applications", 0, date1, "Admin", date2);
	static ApfsFile a = new ApfsFile(null, "a", 1, date1, "Admin", date2);
	static ApfsFile b = new ApfsFile(null, "b", 2, date2, "Admin", date2);
	
	static ApfsDirectory home = new ApfsDirectory(null, "Home", 0, date1, "Admin", date2);
	static ApfsFile c = new ApfsFile(null, "c", 3, date1, "Admin", date2);
	static ApfsFile d = new ApfsFile(null, "d", 4, date2, "Admin", date2);
	
	static ApfsDirectory code = new ApfsDirectory(null, "Code", 0, date2, "Admin", date2);
	static ApfsFile e = new ApfsFile(null, "e", 5, date2, "Admin", date2);
	static ApfsFile f = new ApfsFile(null, "f", 6, date2, "Admin", date2);
	
	static ApfsDirectory apps = new ApfsDirectory(null, "Apps", 0, date2, "Admin", date2);
	
	static ApfsLink x = new ApfsLink(null, "x", 0, date1, null, "Admin", date2);
	static ApfsLink y = new ApfsLink(null, "y", 0, date2, null, "Admin", date2);

	@BeforeAll
	static void init() {

		root.appendChild(applications);
		applications.appendChild(a);
		applications.appendChild(b);
		
		root.appendChild(home);
		home.appendChild(c);
		home.appendChild(d);
		home.appendChild(apps);
		
		home.appendChild(code);
		code.appendChild(e);
		code.appendChild(f);

		home.appendChild(x);
		code.appendChild(y);
		x.setTarget(applications);
		y.setTarget(b);
	}
	
	@Test
	public void GetChildrenOfRootTest() {
		ApfsDirectory dir = root;
		LinkedList<ApfsElement> actualList = dir.getChildren((ApfsElement element1, ApfsElement element2) -> {
			int val1 = 0;
			int val2 = 0;

			if (element1.isDirectory()) {
				val1 = 1;
			} else if (element1.isFile()) {
				val1 = 2;
			} else if (element1.isLink()) {
				val1 = 3;
			}
			
			if (element2.isDirectory()) {
				val2 = 1;
			} else if (element2.isFile()) {
				val2 = 2;
			} else if (element2.isLink()) {
				val2 = 3;
			}
			return ((Integer) val1).compareTo((Integer) val2);
		});
		ApfsElement[] expected = { applications, home };
		ApfsElement[] actual = actualList.toArray(new ApfsElement[actualList.size()]);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void GetChildrenOfHomeTest() {
		ApfsDirectory dir = home;
		LinkedList<ApfsElement> actualList = dir.getChildren((ApfsElement element1, ApfsElement element2) -> {
			int val1 = 0;
			int val2 = 0;

			if (element1.isDirectory()) {
				val1 = 1;
			} else if (element1.isFile()) {
				val1 = 2;
			} else if (element1.isLink()) {
				val1 = 3;
			}
			
			if (element2.isDirectory()) {
				val2 = 1;
			} else if (element2.isFile()) {
				val2 = 2;
			} else if (element2.isLink()) {
				val2 = 3;
			}
			return ((Integer) val1).compareTo((Integer) val2);
		});
		ApfsElement[] expected = { apps, code, c, d, x };
		ApfsElement[] actual = actualList.toArray(new ApfsElement[actualList.size()]);
		assertArrayEquals(expected, actual);
	}
}
