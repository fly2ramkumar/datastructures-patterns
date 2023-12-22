package com.ds.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {	
	String str;
	int openCount;
	int closeCount;
	
	public ParenthesesString(String str, int openCount, int closeCount) {
		this.str = str;
		this.openCount = openCount;
		this.closeCount = closeCount;
	}

	@Override
	public String toString() {
		return "ParenthesesString [str=" + str + ", openCount=" + openCount + ", closeCount=" + closeCount + "]";
	}	
	
}


public class BalancedParenthesis {
	
	private static List<String> generateValidParentheses(int num) {
		
		List<String> result = new ArrayList<>();
		Queue<ParenthesesString> queue = new LinkedList<>();
		queue.add(new ParenthesesString("", 0, 0));
		
		while(!queue.isEmpty()) {
			
			ParenthesesString ps = queue.poll();
			System.out.println(ps.toString());
			
			if(ps.openCount == num && ps.closeCount == num) {
				System.out.println("Inside result condition ");
				System.out.println();
				result.add(ps.str);
			
			}else {
				
				if(ps.openCount < num) {
					queue.add(new ParenthesesString(ps.str +"(", ps.openCount + 1, ps.closeCount) );
				}
				
				if(ps.openCount > ps.closeCount) {
					queue.add(new ParenthesesString(ps.str +")", ps.openCount, ps.closeCount+1) );
				}
				
			}
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("result - "+generateValidParentheses(3));
	}

}
