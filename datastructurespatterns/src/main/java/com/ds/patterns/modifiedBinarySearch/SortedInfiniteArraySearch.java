package com.ds.patterns.modifiedBinarySearch;

class ArrayReader {
	
	int[] arr;
	
	public ArrayReader(int[] arr) {
		this.arr = arr;
	}
	
	public int get(int index) {
		if(index >= arr.length)
			return Integer.MAX_VALUE;
		
		return arr[index];
	}
}

public class SortedInfiniteArraySearch {
	
	private static int find(ArrayReader reader, int key) {
		
		int start = 0;
		int end = 1;
		
		System.out.println(reader.get(6));
		System.out.println(key > reader.get(6));
		
		while(key > reader.get(end)) {
			System.out.println("before -- start - "+start+" end - "+end);
			int newStart = end + 1;			
			end = (end - start + 1)* 2;
			start = newStart;
			System.out.println("after -- start - "+start+" end - "+end);
			System.out.println();
		}
		
		
		while(start <= end) {
			
			int middle = start + (end - start) / 2;
			
			if(key < reader.get(middle)) {
				end = middle - 1;
			} else if(key > reader.get(middle)) {
				start = middle + 1;
			} else {
				return middle;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		/*
		 * ArrayReader reader = new ArrayReader(new int[] {4, 6, 8, 10, 12, 14, 16, 18,
		 * 20, 22, 24, 26, 28, 30}); System.out.println(find(reader, 16));
		 * System.out.println(find(reader, 11));
		 */
		
		ArrayReader reader = new ArrayReader(new int[] {1, 3, 8, 10, 15});
		//System.out.println(find(reader, 15));
		System.out.println(find(reader, 200));
		
		
	}

}
