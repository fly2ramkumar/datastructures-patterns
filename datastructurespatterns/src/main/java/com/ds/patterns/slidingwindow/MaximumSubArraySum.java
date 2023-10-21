package com.ds.patterns.slidingwindow;


public class MaximumSubArraySum {
	
	public static int maxSubArrayLen(int[] arr, int k) {
	        
	        int windowStart = 0;
	        int maximumSum = 0;
	        int tempSum = 0;
	
	        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
	        	tempSum += arr[windowEnd];
	        	
	        	//System.out.println("tempSum --- "+tempSum);
	
	            if(windowEnd - windowStart +1 > k){
	            	tempSum -= arr[windowStart];
	                windowStart++;
	                
	                //System.out.println("Inside --- "+tempSum);
	            }
	            
	            maximumSum = Math.max(maximumSum, tempSum);
	            
	            //System.out.println("tempSum --- "+tempSum);
	        }
	
	        return maximumSum;
	    }

	public static void main(String args[]) {
		
		System.out.println(MaximumSubArraySum.maxSubArrayLen(new int[] {2, 1, 5, 1, 3, 2}, 3));		
		System.out.println(MaximumSubArraySum.maxSubArrayLen(new int[] {2, 3, 5, 1, 1}, 1));
	}

}
