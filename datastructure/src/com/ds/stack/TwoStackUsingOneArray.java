package com.ds.stack;

import com.ds.exception.StackException;

public class TwoStackUsingOneArray {
	int stack[];
	int top1 ;
	int top2 ;
	public TwoStackUsingOneArray(int capacity)	{
		stack = new int[capacity];
		top1 = -1;
		top2 = capacity;
	}
	public void push1(int data) throws StackException	{
		if((top1+1) == top2) {
			throw new StackException(0);
		} else {
			top1 ++;
			stack[top1] = data;
		}
	}
	
	public void push2(int data) throws StackException {
		if((top1+1) == top2) {
			throw new StackException(0);
		} else {
			top2 --;
			stack[top2] = data;
		}
	}
	
	public int pop1() throws StackException	{
		int popData = 0;
		if((top1) < 0) {
			throw new StackException(1);
		} else {
			popData = stack[top1] ;
			top1 --;
		}
		return popData;
	}
	
	public int pop2() throws StackException	{
		int popData = 0;
		if((top2) > (stack.length-1)) {
			throw new StackException(1);
		} else {
			popData = stack[top2] ;
			top2 ++;
		}
		return popData;
	}
	
	public int size1() {
		return top1+1;
	}
	public int size2() {
		return stack.length - top2;
	}
	
	public void show1()	{
		int i = 0;
		for(; i <= top1 ; i++)	{
			System.out.println(stack[i]);
		}
		
	}
	
	public void show2()	{
		int i = stack.length - 1;
		for(; i >= top2 ; i--)	{
			System.out.println(stack[i]);
		}
	}

}
