package com.ds.patterns.slidingwindow.temp;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatedSubString {

	private static int findLongestNonRepeatedSubStringWithSet(String str) {

		Set<Character> distinctChars = new HashSet<>();

		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			distinctChars.add(rightChar);
		}

		return distinctChars.size();
	}

	public static void main(String[] args) {
		System.out.println(LongestNonRepeatedSubString.findLongestNonRepeatedSubStringWithSet("aabccbb"));
	}

}
