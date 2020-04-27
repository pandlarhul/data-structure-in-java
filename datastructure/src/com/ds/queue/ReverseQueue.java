package com.ds.queue;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.stack.LStack;

public class ReverseQueue {
	public static void main(String[] args) {
		demoReverseUsingLinked();
//		LinkedQueue<Integer> original = new LinkedQueue<Integer>();
//		System.out.println(original.isEmpty());
//		original.enQueue(10);
//		System.out.println(original.isEmpty());
//		
//		try {
//			System.out.println(original.deQueue());
//			System.out.println(original.isEmpty());
//		} catch (QueueException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public static void demoReverseUsingLinked() {
		LinkedQueue<Integer> original = new LinkedQueue<Integer>();
		for (int i = 0; i <= 10; i++) {
			original.enQueue(i*10);	
			
		}
		try {
			original.show();
			original = reverse(original);
			original.show();
		} catch (QueueException | StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	public static void demoFixedArrayReverse(){
		FixedArrayQueue queue = new FixedArrayQueue(5);
		try {
			queue.enQueue(10);
			queue.enQueue(20);
			queue.enQueue(30);
			queue.enQueue(40);
			queue.enQueue(50);
			System.out.println("Array before reverse:");
			queue.show();
			queue = reverse(queue);
			System.out.println("Array after reverse:");
			queue.show();
		} catch (QueueException | StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static FixedArrayQueue reverse(FixedArrayQueue original) throws QueueException, StackException	{
		FixedArrayQueue queue = new FixedArrayQueue(original.size());
		LStack<Integer> stack = new LStack<Integer>();
		while(!original.isEmptyQueue())	{
			stack.push(original.deQueue());
		}
		
		while(!stack.isEmpty())	{
			queue.enQueue(stack.pop());
		}
		return queue;
	}
	
	public static <T> LinkedQueue<T> reverse(LinkedQueue<T> original) throws QueueException, StackException	{
		LStack<T> stack = new LStack<T>();
		LinkedQueue<T> queue = new LinkedQueue<T>();
		while(!original.isEmpty())	{
			stack.push(original.deQueue());
		}
		stack.show();
		
		while(!stack.isEmpty()) {
			queue.enQueue(stack.pop());
		}
		return queue;
	}
}
