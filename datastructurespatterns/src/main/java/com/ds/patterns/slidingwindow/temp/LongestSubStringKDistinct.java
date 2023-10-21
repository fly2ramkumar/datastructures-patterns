package com.ds.patterns.slidingwindow.temp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringKDistinct {
	
	private static int findLength(String str, int k) {
		
		int windowStart = 0;
		int maxLength = 0;
		Map<Character, Integer> ditinctCharsMap = new HashMap<>();
		
		//araac
		
		for(int windowEnd = 0; windowEnd < str.length() -1; windowEnd++) {
			
			char rightChar = str.charAt(windowEnd); 
			ditinctCharsMap.put(rightChar, ditinctCharsMap.getOrDefault(rightChar, 0) + 1);
			
			if(ditinctCharsMap.size() > k) {
				
				char leftChar = str.charAt(windowStart); 
				ditinctCharsMap.put(leftChar, ditinctCharsMap.getOrDefault(leftChar, 0) - 1);
				
				if(ditinctCharsMap.get(leftChar) == 0) {
					ditinctCharsMap.remove(leftChar);
				}
				
				windowStart++;
			}
			
			maxLength = Math.max(maxLength, windowEnd - windowStart +1);
		}
			
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(LongestSubStringKDistinct.findLength("araaci", 2));
		System.out.println(LongestSubStringKDistinct.findLength("araaci", 1));
		System.out.println(LongestSubStringKDistinct.findLength("cbbebi", 3));
	}

}
