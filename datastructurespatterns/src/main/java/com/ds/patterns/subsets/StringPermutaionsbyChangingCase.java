package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class StringPermutaionsbyChangingCase {
	
	//Custom implementation
	private static List<String> createPermutations(String str) {
		
		List<String> result = new ArrayList<>();
		
		Queue<List<Character>> queue = new LinkedList<>();
		queue.add(new ArrayList<>());
		
		for(int i=0; i< str.length(); i++) {
			
			int queueLength = queue.size();
			
			for(int j=0; j< queueLength; j++) {
				
				List<Character> oldIntermediateList = queue.poll();
				
				List<Character> newIntermediateList = new ArrayList<>(oldIntermediateList);
				newIntermediateList.add(str.charAt(i));
				
				if(str.length() == newIntermediateList.size()) {
					result.add(newIntermediateList.stream().map(e-> e.toString()).collect(Collectors.joining()));
				}else {
					queue.add(newIntermediateList);
				}
				
				if(Character.isLetter(str.charAt(i))) {
					
					List<Character> newIntermediateUpperCaseList = new ArrayList<>(oldIntermediateList);
					newIntermediateUpperCaseList.add(Character.toUpperCase(str.charAt(i)));
					
					if(str.length() == newIntermediateUpperCaseList.size()) {
						result.add(newIntermediateUpperCaseList.stream().map(e-> e.toString()).collect(Collectors.joining()));
					}else {
						queue.add(newIntermediateUpperCaseList);
					}
					
				}
				
		}
			
		}
		
		return result;
	}
	
	//grokking implementation
	private static List<String> generatePermutations(String str) {
		
		List<String> result = new ArrayList<>();
		
		if(str == null)
			return result;
		
		result.add(str);
		
		
		for(int i=0; i< str.length(); i++) {
			
			System.out.println("str.charAt(i) -- "+str.charAt(i));
			
			if(Character.isLetter(str.charAt(i))){
				
				int n = result.size();
				
				for(int j=0; j < n; j++) {
					
					System.out.println("Input -- "+result.get(j));
					
					char[] chs = result.get(j).toCharArray();
					
					if(Character.isUpperCase(chs[i])) {
						chs[i] = Character.toLowerCase(chs[i]);
					
					} else {
						chs[i] = Character.toUpperCase(chs[i]);
					}
					
					result.add(String.valueOf(chs));
					
					System.out.println("Output -- "+String.valueOf(chs));
					System.out.println();
					
				}
				
				
			}
		}
		
		
		return result;
	}
	
	
	public static void main(String[] args) {
		System.out.println(generatePermutations("ad52").toString());
		System.out.println(generatePermutations("ab7c").toString());
	}


}
