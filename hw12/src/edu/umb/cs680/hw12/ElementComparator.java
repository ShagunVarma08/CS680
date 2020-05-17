package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementComparator implements Comparator<ApfsElement> {
	int fsElement1Value;
	int fsElement2Value;

	public int compare(ApfsElement fs1, ApfsElement fs2) {
		if (fs1.isDirectory()) {
			fsElement1Value = 1;
		} else if (fs1.isFile()) {
			fsElement1Value = 2;
		} else if (fs1.isLink()) {
			fsElement1Value = 3;
		}
		if (fs2.isDirectory()) {
			fsElement2Value = 1;
		} else if (fs2.isFile()) {
			fsElement2Value = 2;
		} else if (fs2.isLink()) {
			fsElement2Value = 3;
		}
		return ((Integer) fsElement1Value).compareTo((Integer) fsElement2Value);
	}
}