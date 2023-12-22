package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SubSetOfDuplicateNumbers {
	
	private static List<List<Integer>> createSubSets(int[] nums){
		
		Arrays.sort(nums);
		
		List<List<Integer>> resultSet = new ArrayList<>();
		resultSet.add(new ArrayList<>());
	
		int previousNum = -1;
		int previousSubSetLength = -1;
		
		for(int currentNum : nums) {
			
			int startIndex = 0;
			
			if(previousNum == currentNum) {
				startIndex = previousSubSetLength;
			}
			
			int currentSubSetsLength = resultSet.size();
			previousSubSetLength = resultSet.size();
			
			for(int i=startIndex; i < currentSubSetsLength; i++) {
				
				List<Integer> intermediateList = new ArrayList<>(resultSet.get(i));
				intermediateList.add(currentNum);
				resultSet.add(intermediateList);
			}
			
			
			previousNum = currentNum;
	
		}
		
		return resultSet;
	}
	
	public static void main(String[] args) {
		System.out.println(createSubSets(new int[] {1, 3, 5, 3}).toString());
	}
	
	

}
