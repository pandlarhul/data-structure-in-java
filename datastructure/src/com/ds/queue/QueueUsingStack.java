package com.ds.queue;

import com.ds.exception.QueueException;
import com.ds.exception.StackException;
import com.ds.stack.LStack;

public class QueueUsingStack<T> {
	private LStack<T> stack1;
	private LStack<T> stack2;
	int size;
	public QueueUsingStack() {
		stack1 = new LStack<T>();
		stack2 = new LStack<T>();
		size = 0;
	}
	
	public void enQueue(T enQueueData)	{
		stack1.push(enQueueData);
	}
	
	public T deQueue() throws QueueException, StackException	{
		T deQueueData;
		System.out.println(stack1);
		if(stack1.isEmpty()) {
			System.out.println("call");
			throw new QueueException(1);
		} else {
			while(!stack1.isEmpty())	{
				stack2.push(stack1.pop());
			}
			deQueueData = stack2.pop();
			while(!stack2.isEmpty())	{
				stack1.push(stack2.pop());
			}
		}
		return deQueueData;
	}
	
	
}
