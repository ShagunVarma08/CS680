package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class ApfsFileSearchVisitorTest {
	
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

	@BeforeAll
	static void init() {

		root.appendChild(applications);
		applications.appendChild(a);
		applications.appendChild(b);
		
		root.appendChild(home);
		home.appendChild(c);
		home.appendChild(d);
		
		home.appendChild(code);
		code.appendChild(e);
		code.appendChild(f);

		home.appendChild(x);
		code.appendChild(y);
		x.setTarget(applications);
		y.setTarget(b);
	}
	
	@Test
	public void fileASearchTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("a");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] expected = { a };
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void fileBSearchTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("b");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] expected = { b };
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void fileCSearchTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("c");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] expected = { c };
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void fileDSearchTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("d");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] expected = { d };
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void fileESearchTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("e");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] expected = { e };
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void fileFSearchTest() {
		ApfsFileSearchVisitor visitor = new ApfsFileSearchVisitor("f");
		root.accept(visitor);
		LinkedList<ApfsFile> files = visitor.getFoundFiles();
		ApfsFile[] expected = { f };
		ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
		assertArrayEquals(expected, actual);
	}
}
