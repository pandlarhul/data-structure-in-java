package com.ds.stack;

import com.ds.exception.StackException;

public class UseGetMinimum {
	public static void main(String[] args) {
		MinValueUsingTwoStack<Integer> stack = new MinValueUsingTwoStack<Integer>();
		stack.push(2);
		stack.push(6);
		stack.push(4);
		stack.push(1);
		stack.push(5);
		try {
			stack.showMin();
			System.out.println();
			stack.showMain();
			System.out.println();
			System.out.println(stack.getMinimum());
			
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
