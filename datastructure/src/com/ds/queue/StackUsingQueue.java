package com.ds.queue;

import com.ds.exception.QueueException;

public class StackUsingQueue<T> {
	private LinkedQueue<T> queue1 ;
	private LinkedQueue<T> queue2 ;
	public StackUsingQueue()	{	
		queue1 = new LinkedQueue<T>();
		queue2 = new LinkedQueue<T>();
	}
	
	
	public void push(T data)	{
		queue1.enQueue(data);
	}
	
	
	public T pop() throws QueueException	{
		int i = 0;
		T data ;	
		while(i < queue1.size() - 1 )	{
			T data1 = queue1.deQueue();
			queue2.enQueue(data1);
		}
		
		data = queue1.deQueue();
		while(!queue2.isEmpty() )	{
			T data1 = queue2.deQueue();
			queue1.enQueue(data1);
		}
		return data; 
	}
	
	
	public int size()	{
		return queue1.size();
	}
	
	public boolean isEmpty()	{
		return queue1.isEmpty();
	}

}
