package com.ds.queue;

import com.ds.exception.QueueException;

public class UseStackUsingQueue {
	public static void main(String[] args) {
		StackUsingQueue<Integer> stack = new StackUsingQueue<Integer>();
		stack.push(10);
		stack.push(20);
		try {
			System.out.println("main stack = "+stack.pop());
			System.out.println("main stack="+stack.pop());
			stack.push(30);
			stack.push(40);
			System.out.println("main stack = "+stack.pop());
			System.out.println("main stack="+stack.pop());
			System.out.println("main stack="+stack.pop());
			
			
		} catch (QueueException e) {
			System.out.println(e);
		}
		
		
	}

}
