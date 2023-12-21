package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
	
	private static List<List<Integer>> findSubSetOfGivenArray(int[] nums) {
		
		List<List<Integer>> subsetList = new ArrayList<>();
		subsetList.add(new ArrayList<>());
		
		for(int currentNum : nums) {			
			int length = subsetList.size();
			
			for(int i=0; i< length; i++) {
				List<Integer> innerList = new ArrayList<>(subsetList.get(i));
				innerList.add(currentNum);
				subsetList.add(innerList);
			}		
		}
		
		return subsetList;
	}
	
	public static void main(String[] args) {
		System.out.println(findSubSetOfGivenArray(new int[] {1, 5, 3}).toString());
	}

}
