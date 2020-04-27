package com.ds.stack;

import com.ds.exception.StackException;

class Stack<T>{
	int capacity;
	int size;
	int top;
	int stack[];
	public Stack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		top = -1;
	}
	public void push(int data)	throws StackException{
		if(top >= capacity-1) {
			throw new StackException(0);
		} else {
			size ++;
			stack[++top] = data;
			}
	}
	
	public int pop()	throws StackException{
		if(top == -1) {
			throw new StackException(1);
		} else {
			size ++;
			return stack[top--];
		}
	}
}
