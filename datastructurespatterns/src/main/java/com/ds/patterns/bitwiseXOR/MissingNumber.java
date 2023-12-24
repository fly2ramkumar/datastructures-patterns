package com.ds.patterns.bitwiseXOR;

public class MissingNumber {
	
	private static int findMissingNumber(int[] arr) {
		
		int n = arr.length - 1;
		
		int x1 = 1;
		
		for(int i = 2; i<= n; i++) {
			System.out.println("x1 - "+x1+" i -"+i+" (x1 ^ i) - "+(x1 ^ i));
			x1 = x1 ^ i;
		}
		
		System.out.println("x1 -- "+x1);
		System.out.println();
		
		int x2 = arr[0];
		for(int i = 1; i< arr.length - 1; i++) {
			System.out.println("x2 - "+x2+" arr[i] -"+arr[i]+" (x2 ^ arr[i]) - "+(x2 ^ arr[i]));
			x2 = x2 ^ arr[i];
		}
		
		System.out.println("x2 -- "+x2);
		System.out.println();
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findMissingNumber(new int[] {1, 5, 2, 6, 4}));
	} 
	

}
