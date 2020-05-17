package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement> {

	@Override
	public int compare(ApfsElement fs1, ApfsElement fs2) {
		return fs1.getName().compareTo(fs2.getName());
	}
}