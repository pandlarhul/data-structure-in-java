package com.ds.stack;

import com.ds.exception.StackException;

public class MinValueUsingTwoStack<T extends Comparable<T>> {
	private LStack<T> mainStack;
	private LStack<T> minStack;
	private int size ;
	public MinValueUsingTwoStack()	{
		mainStack = new LStack<T>();
		minStack = new LStack<T>();
	}
	public void push(T data)	{
		
		if(size == 0) {
			mainStack.push(data);
			minStack.push(data);
		} else {
			if(data.compareTo(minStack.peek()) > 0 ) {
//				System.out.println("data="+data);
//				T temp = minStack.peek();
//				System.out.println("temp="+temp);
//				minStack.push(temp);
				mainStack.push(data);
			} else {
				minStack.push(data);
				mainStack.push(data);
			}
		}
		size++;
	}
	
	public T pop() throws StackException	{
		size --;
		T popData = mainStack.pop();
		minStack.pop();
		mainStack.pop();
		return popData;
		
	}
	
	public T getMinimum() throws StackException	{
		return minStack.peek();
	}
	
	public void showMin()	{
		minStack.show();
	}
	
	public void showMain()	{
		mainStack.show();
	}
	
}
