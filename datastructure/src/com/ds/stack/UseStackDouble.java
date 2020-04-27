package com.ds.stack;

import com.ds.exception.StackException;

public class UseStackDouble {
	public static void main(String[] args) {
		TwoStackUsingOneArray stack = new TwoStackUsingOneArray(4);
		try {
			stack.push2(10);
			stack.push2(20);
			stack.push2(30);
			stack.push2(40);
			stack.push1(40);
			stack.show1();
			//stack.push1(50);
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
