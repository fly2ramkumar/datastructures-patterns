package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AbbreviatedWord {
	
	StringBuilder str;
	int start;
	int count;
	
	public AbbreviatedWord(StringBuilder str, int start, int count) {
		super();
		this.str = str;
		this.start = start;
		this.count = count;
	}

	@Override
	public String toString() {
		return "AbbreviatedWord [str=" + str + ", start=" + start + ", count=" + count + "]";
	}
	
}

public class GeneralizedAbbreviations {
	
	// Incomplete
	
	private static List<String> generateGeneralizedAbbreviations(String word) {
		
		int wordLength = word.length();	
		List<String> result = new ArrayList<>();
		
		Queue<AbbreviatedWord> queue = new LinkedList<>();
		queue.add(new AbbreviatedWord(new StringBuilder(), 0, 0));
		
		while(!queue.isEmpty()) {
			
			AbbreviatedWord abWord = queue.poll();
			System.out.println(abWord.toString());
			
			if(abWord.start == wordLength) {
				if(abWord.count != 0) {
					abWord.str.append(abWord.count);
				}
				
				result.add(abWord.str.toString());
			
			}else {
				queue.add(new AbbreviatedWord(new StringBuilder(abWord.str), abWord.start+1, abWord.count+1));
				
				if(abWord.count != 0) {
					abWord.str.append(abWord.count);
					queue.add(new AbbreviatedWord(new StringBuilder(abWord.str).append(word.charAt(abWord.start)), abWord.start+1, abWord.count+1));
				}
				
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(generateGeneralizedAbbreviations("BAT").toString());
	}
}
