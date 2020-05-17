package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {

	public int compare(ApfsElement fs1, ApfsElement fs2) {
		return fs2.getName().compareTo(fs1.getName());
	}

}