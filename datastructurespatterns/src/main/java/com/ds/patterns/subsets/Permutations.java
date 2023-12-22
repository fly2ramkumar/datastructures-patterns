package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
	
	private static List<List<Integer>> generatePermutations(int[] nums) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		Queue<List<Integer>> permutationQueue = new LinkedList<>(); 
		permutationQueue.add(new ArrayList<>());
		
		
		for(int currentNum : nums) {
			
			int queueLength = permutationQueue.size();
			
			for(int i=0; i< queueLength; i++) {
				
				List<Integer> oldIntermediateList = permutationQueue.poll();
				
				
					for(int j=0; j <= oldIntermediateList.size(); j++) {
						
						List<Integer> newIntermediateList = new ArrayList<Integer>(oldIntermediateList);						
						newIntermediateList.add(j, currentNum);
						
						if(newIntermediateList.size() == nums.length) {
							result.add(newIntermediateList);
						}else {
							permutationQueue.add(newIntermediateList);
						}
						
					}
			}
			
			
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(generatePermutations(new int[] {1, 2, 3}).toString());
	}
}
