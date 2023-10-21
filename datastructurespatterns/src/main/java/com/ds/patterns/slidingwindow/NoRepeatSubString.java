package com.ds.patterns.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import com.ds.patterns.slidingwindow.temp.LongestNonRepeatedSubString;

public class NoRepeatSubString {
	
	 public static int lengthOfLongestSubstring(String str) {

	        int windowStart = 0;
	        int maxLength = 0;
	        Map<Character, Integer> uniqueCharsMap = new HashMap<>();

	        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){	            
	           char rightChar = str.charAt(windowEnd);

	           if(uniqueCharsMap.get(rightChar) != null){
	               windowStart = windowEnd;
	           }

	           uniqueCharsMap.put(rightChar, windowEnd);
	           maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
	        }
	        
	        return maxLength;
	    }
	 
	 public static void main(String[] args) {	
		// System.out.println(NoRepeatSubString.lengthOfLongestSubstring("dvdf"));
		 System.out.println(NoRepeatSubString.lengthOfLongestSubstring("aabccbb"));
		 System.out.println(NoRepeatSubString.lengthOfLongestSubstring("abbbb"));
		 System.out.println(NoRepeatSubString.lengthOfLongestSubstring("abccde"));
	}

}
