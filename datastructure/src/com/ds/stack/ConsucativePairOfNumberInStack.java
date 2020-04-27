package com.ds.stack;

import com.ds.exception.StackException;

public class ConsucativePairOfNumberInStack {
	public static void main(String[] args) {
		LStack<Integer> stack = new LStack<Integer>();
		// 4, 5, -2, -3, 11, 10, 5, 6, 20
		stack.push(4);
		stack.push(5);
		stack.push(-2);
		stack.push(-3);
		stack.push(11);
		stack.push(10);
		stack.push(5);
		stack.push(10);
		//stack.push(20);
		stack = stack.reverse();
		stack.showWithAddress();
		//System.out.println();
		try {
			System.out.println(isConsucativePair(stack));
		} catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isConsucativePair(LStack<Integer> stack) throws StackException	{
		while((stack.size() > 1) ){
			int num1 = stack.peek();
			int num2 = stack.peek();
			System.out.println("num1="+num1+" num2="+num2);
				if(Math.abs(num1 - num2) != 1) {
					break;
				}
				stack.pop();
				stack.pop();
			}
		if(stack.size() == 1 || stack.size() == 0) {
			return true;
		} 
		return false;
	}

}
