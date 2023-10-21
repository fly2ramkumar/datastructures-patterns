package com.ds.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKDistinctChars {
	
	private static int findLength(String str, int k) {
		
		int windowStart = 0;
		Map<Character, Integer> uniqueCharsMap = new HashMap<>();
		int maxLength = 0;
		
		for(int windowEnd = 0; windowEnd < str.length(); windowEnd ++) {
			char rightChar = str.charAt(windowEnd);
			uniqueCharsMap.put(rightChar, uniqueCharsMap.getOrDefault(rightChar, 0)+1);
			
			while(uniqueCharsMap.size() > k) {
				
				char leftChar =  str.charAt(windowStart);
				
				uniqueCharsMap.put(leftChar, uniqueCharsMap.get(leftChar) - 1);
				
				if(uniqueCharsMap.get(leftChar) == 0) {
					uniqueCharsMap.remove(leftChar);
				}
				
				windowStart++;
			}
			
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(LongestSubStringWithKDistinctChars.findLength("araaci", 2));
		System.out.println(LongestSubStringWithKDistinctChars.findLength("araaci", 1));
		System.out.println(LongestSubStringWithKDistinctChars.findLength("cbbebi", 3));
	}

}
