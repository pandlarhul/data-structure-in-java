package com.ds.hackerearth;

import java.util.LinkedList;
import java.util.List;

public class DifferenceOfInverseSubsequence {
	public static void main(String[] args) {
		int a[] = {1,2,3,0,2,3,4,5,6,7,8,67,10,34,56,23,90,10};
		System.out.println(maximumSubSequence(a));
	}
	public static int maximumSubSequence(int a[])	{
		List subSequences[] = new List[a.length];
		List<Integer> sequence = new LinkedList<Integer>();
		for(int i = 0; i < a.length ; i++)	{
			sequence = new LinkedList<Integer>();
			sequence.add(a[i]);
		}
		for(int i = 0 ; i< a.length ; i++)	{
			
		}
		
	}

}
