package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class ApfsElementTest {

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
	
	static ApfsLink x = new ApfsLink(null, "x", 0, date1, null, "Admin", date2);
	static ApfsLink y = new ApfsLink(null, "y", 0, date2, null, "Admin", date2);
	
	@Test
	public void getChildrenTest() {
		ApfsElement apfs = new ApfsElement(null, "root", 0, date1, "Admin", date2);
		
		apfs.appendChild(root);
		
		apfs.appendChild(applications);
		apfs.appendChild(a);
		apfs.appendChild(b);
		
		apfs.appendChild(home);
		apfs.appendChild(c);
		apfs.appendChild(d);
		
		apfs.appendChild(code);		
		apfs.appendChild(e);
		apfs.appendChild(f);
		
		apfs.appendChild(x);
		apfs.appendChild(y);
		
		LinkedList<ApfsElement> apfsChildren = apfs.getChildren();
		ApfsElement[] actual = apfsChildren.toArray(new ApfsElement[apfsChildren.size()]);
		ApfsElement[] expected = { root, applications, a, b, home, c, d, code,  e, f, x, y };
		assertArrayEquals(expected, actual);
	}
}
