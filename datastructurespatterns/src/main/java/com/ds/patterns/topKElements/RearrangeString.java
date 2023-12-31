package com.ds.patterns.topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class MyEntry implements Map.Entry<Character, Integer> {
    private final Character key;
    private Integer value;

    public MyEntry(Character key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Character getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer setValue(Integer value) {
    	Integer old = this.value;
        this.value = value;
        return old;
    }
}

public class RearrangeString {
	
	private static String rearrange(String str) {
		
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for(int i=0; i< str.length(); i++) {
			frequencyMap.put(str.charAt(i), frequencyMap.getOrDefault(str.charAt(i), 0)+1);
		}
		
		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
		
		StringBuilder result = new StringBuilder(); 
		
		for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {			
			if(entry.getValue() == 1) {
				result.append(entry.getKey());
			}else {
				maxHeap.add(entry);
			}		
		}
		
		while(!maxHeap.isEmpty()) {
			
			if(maxHeap.size() == 1 && maxHeap.peek().getValue() > 1)
				return "";
			
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			result.append(entry.getKey());
			
			if(entry.getValue() > 1) {
				entry.setValue(entry.getValue()-1);
				maxHeap.add(entry);
				//maxHeap.add(new MyEntry(entry.getKey(), entry.getValue()-1));
			}
				
		}
		
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println("output - "+rearrange("aappp"));
		System.out.println("output - "+rearrange("Programming"));
		System.out.println("output - "+rearrange("aapa"));
	}
	
}
