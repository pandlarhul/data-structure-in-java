package com.ds.queue;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.stack.LStack;

public class ReverseQueueAndStoreInStack {
	public static void main(String[] args) {
		LinkedQueue<String> queue = new LinkedQueue<String>();
		queue.enQueue("first");
		queue.enQueue("Second");
		queue.enQueue("Third");
		queue.enQueue("Forth");
		queue.enQueue("Fifth");
		queue.enQueue("sixth");
		LStack<String> stack;
		try {
			stack = operation(queue);
			stack.show();
		} catch (QueueException | StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("unused")
	private static <T> LStack<T> operation(LinkedQueue<T> queue) throws QueueException, StackException {
		LStack<T> stack = new LStack<T>();
		while(!queue.isEmpty())	{
			stack.push(queue.deQueue());
		}
		
		while(!stack.isEmpty())	{
			queue.enQueue(stack.pop());
		}
		
		while(!queue.isEmpty())	{
			stack.push(queue.deQueue());
		}
		
		return stack;
	}

}
