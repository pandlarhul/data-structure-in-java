package com.ds.queue;

public class MaximumSumInSlidingWindow {
	public static void main(String[] args) {
		long a[] = {1,3,-1,-3,5,3,6,7};
		long b[] = maximumSumInWindow(a, 3); 
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
	}

	private static long[] maximumSumInWindow(long[] a, int windowSize) {
		long b[] = new long[a.length - windowSize + 1];
		int k = 0;
		int lengthb = a.length - windowSize + 1;
		
		for(int i = 0 ; i < lengthb ; i++) {
			long max = -99999999;
			for (int j = 0; j < windowSize; j++) {
				if(max < a[i+j]) {
					max = a[i+j];
				}
			}
			b[k++] = max;
		}
		return b;
	}

}
